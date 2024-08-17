package pro.sky.Map.service;

import org.springframework.stereotype.Service;
import pro.sky.Map.Employee;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeServiceInterface{
    private final Map<String, Employee> employees = new HashMap<>();
    @Override
    public Employee addEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
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
}
