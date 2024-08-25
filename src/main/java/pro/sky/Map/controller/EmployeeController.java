package pro.sky.Map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sky.Map.Employee;
import pro.sky.Map.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeServiceInterface employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceInterface employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam double salary, @RequestParam int departmentId) {
        return employeeService.addEmployee(firstName, lastName, salary, departmentId );
    }

    @DeleteMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
}