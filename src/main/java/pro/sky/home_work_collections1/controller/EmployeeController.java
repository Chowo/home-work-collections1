package pro.sky.home_work_collections1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.home_work_collections1.model.Employee;
import pro.sky.home_work_collections1.service.EmployeeAlreadyAddedException;
import pro.sky.home_work_collections1.service.EmployeeNotFoundException;
import pro.sky.home_work_collections1.service.EmployeeServiceInterface;
import pro.sky.home_work_collections1.service.EmployeeStorageIsFullException;

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
        return employeeService.addNewEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }


}
