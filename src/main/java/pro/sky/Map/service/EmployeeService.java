package pro.sky.Map.service;

import org.springframework.stereotype.Service;
import pro.sky.Map.Employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceInterface{
    private final Map<String, Employee> employees = new HashMap<>();
    @Override
    public Employee addEmployee(String firstName, String lastName, double salary, int departmentId) {

        Employee employee = new Employee(firstName, lastName,  salary, departmentId);
        String key = generateKey(firstName, lastName);

        if (employees.containsKey(key)) {
            throw new RuntimeException("Сотрудник уже существует");
        }
        employees.put(key, employee);
        return employee;
    }


    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = generateKey(firstName, lastName);
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = generateKey(firstName, lastName);
        return employees.get(key);
    }

    private String generateKey(String firstName, String lastName) {
        return firstName + "_" + lastName;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee getEmployeeWithMinSalary(int departmentId) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        return employees.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
