package pro.sky.home_work_collections1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.home_work_collections1.model.Employee;
import pro.sky.home_work_collections1.service.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeServiceInterface employeeService;

    public EmployeeController(EmployeeServiceInterface employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> printAllEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName) {
        Employee employee = null;
        try {
            employee = employeeService.addNewEmployee(firstName, lastName);
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println(e.getMessage());
        } catch (EmployeeStorageIsFullException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName) {
        Employee employee = null;
        try {
            employee = employeeService.deleteEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }
    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName) {
        Employee employee = null;
        try {
            employee = employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }


}
