package pro.sky.home_work_collections1.service;

import org.springframework.stereotype.Service;
import pro.sky.home_work_collections1.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getDepartmentsEmployee(int department) {
        List<Employee> listOfEmployeesByDepartment = employeeService.getEmployees().values().stream().filter(e -> e.getDepartment() == department).toList();
        if (listOfEmployeesByDepartment.isEmpty()) {
            throw new NullPointerException();
        }
        return listOfEmployeesByDepartment;
    }
    @Override
    public Double sumOfSalariesByDepartment(int department) {
        return employeeService.getEmployees().values().stream().filter(e -> e.getDepartment() == department).mapToDouble(Employee::getSalary).sum();
    }

    @Override
    public Double maxDepartmentSalary(int department) {
        try {
            return employeeService.getEmployees().values().stream().filter(e -> e.getDepartment() == department).max(Comparator.comparing(Employee::getSalary)).orElseThrow().getSalary();
        } catch (NoSuchElementException e) {
            return 0.0;
        }

    }

    @Override
    public Double minDepartmentSalary(int department) {
        try {
            return employeeService.getEmployees().values().stream().filter(e -> e.getDepartment() == department).min(Comparator.comparing(Employee::getSalary)).orElseThrow().getSalary();
        } catch (NoSuchElementException e) {
            return 0.0;
        }
    }
    @Override
    public Map<Integer, List<Employee>> employeesByDepartment() {
        return employeeService.getEmployees().values().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }


}
