package pro.sky.home_work_collections1.service;

import org.springframework.stereotype.Service;
import pro.sky.home_work_collections1.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeDepartmentService {

    private final EmployeeService employees;

    public EmployeeDepartmentService(EmployeeService employees) {
        this.employees = employees;
    }

    public Employee maxDepartmentSalary(int department) {
        return employees.getEmployees()
                .values()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }

    public Employee minDepartmentSalary(int department) {
        return employees.getEmployees()
                .values()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }

    public List<Employee> getDepartmentsEmployee(int department) {
        return employees.getEmployees()
                .values()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    public Map<Integer, List<Employee>> employeesByDepartment () {
        return employees.getEmployees()
                .values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }


}
