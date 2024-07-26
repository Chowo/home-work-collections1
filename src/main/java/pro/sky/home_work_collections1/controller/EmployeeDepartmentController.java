package pro.sky.home_work_collections1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.home_work_collections1.model.Employee;
import pro.sky.home_work_collections1.service.EmployeeDepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/department")
public class EmployeeDepartmentController {
    public final EmployeeDepartmentService service;

    public EmployeeDepartmentController(EmployeeDepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee employeeWithHighestSalary(@RequestParam("department") int department) {
        return service.maxDepartmentSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee employeeWithLowestSalary(@RequestParam("department") int department) {
        return service.minDepartmentSalary(department);
    }

    @GetMapping("/all")
    public List<Employee> allDepartmentEmployees(@RequestParam("department") int department) {
        return service.getDepartmentsEmployee(department);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> allEmployeesSortedByDepartments() {
        return service.employeesByDepartment();
    }


}
