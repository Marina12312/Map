package pro.sky.Map.service;

import pro.sky.Map.Employee;

public interface EmployeeServiceInterface {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
}
