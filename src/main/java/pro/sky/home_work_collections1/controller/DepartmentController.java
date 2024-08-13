package pro.sky.home_work_collections1.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.home_work_collections1.model.Employee;
import pro.sky.home_work_collections1.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }


    @GetMapping("/{id}/employees")
    public List<Employee> allDepartmentEmployees(@PathVariable("id") int department) {
        return service.getDepartmentsEmployee(department);
    }
    @GetMapping("/{id}/salary/sum")
    public Double sumOfSalariesByDepartment(@PathVariable("id") int department) {
        return service.sumOfSalariesByDepartment(department);
    }

    @GetMapping("/{id}/salary/max")
    public Double employeeWithHighestSalary(@PathVariable("id") int department) {
        return service.maxDepartmentSalary(department);
    }

    @GetMapping("/{id}/salary/min")
    public Double employeeWithLowestSalary(@PathVariable("id") int department) {
        return service.minDepartmentSalary(department);
    }

    @GetMapping("/employees")
    public Map<Integer,List<Employee>> allEmployeesSortedByDepartments() {
        return service.employeesByDepartment();
    }


}
