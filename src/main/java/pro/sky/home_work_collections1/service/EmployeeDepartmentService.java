package pro.sky.home_work_collections1.service;

import org.springframework.stereotype.Service;
import pro.sky.home_work_collections1.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeDepartmentService {

    private final Map<String, Employee> employees = new EmployeeService().getEmployees();

    public Employee maxDepartmentSalary(int department) {
        return employees.values().stream().filter(e -> e.getDepartment() == department).max(Comparator.comparing(Employee::getSalary)).get();
    }

    public Employee minDepartmentSalary(int department) {
        return employees.values().stream().filter(e -> e.getDepartment() == department).min(Comparator.comparing(Employee::getSalary)).get();
    }

    public List<Employee> getDepartmentsEmployee(int department) {
        return employees.values().stream().filter(e -> e.getDepartment() == department).collect(Collectors.toList());
    }
    public List<Employee> employeesByDepartment () {
        return employees.values().stream().sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors.toList());
    }


}
