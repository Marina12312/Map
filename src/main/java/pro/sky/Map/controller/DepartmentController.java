package pro.sky.Map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Map.Employee;
import pro.sky.Map.service.EmployeeServiceInterface;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final EmployeeServiceInterface employeeService;

    @Autowired
    public DepartmentController(EmployeeServiceInterface employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam int departmentId) {
        return employeeService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam int departmentId) {
        return employeeService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getEmployeesByDepartment(@RequestParam int departmentId) {
        return employeeService.getEmployeesByDepartment(departmentId);
    }

    @GetMapping("/all-departments")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        return employeeService.getAllEmployeesByDepartments();
    }
}