package pro.sky.Map.service;

import pro.sky.Map.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeServiceInterface {
    Employee addEmployee(String firstName, String lastName, double salary, int departmentId);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    // Методы для работы с отделами
    Employee getEmployeeWithMaxSalary(int departmentId);
    Employee getEmployeeWithMinSalary(int departmentId);
    List<Employee> getEmployeesByDepartment(int departmentId);
    Map<Integer, List<Employee>> getAllEmployeesByDepartments();
}
