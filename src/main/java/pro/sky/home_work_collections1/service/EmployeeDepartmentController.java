package pro.sky.home_work_collections1.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.home_work_collections1.model.Employee;

import java.util.List;

@RestController
@RequestMapping("/department")
public class EmployeeDepartmentController {
    EmployeeDepartmentService service;

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
    public List<Employee> allEmployeesSortedByDepartments() {
        return service.employeesByDepartment();
    }


}
