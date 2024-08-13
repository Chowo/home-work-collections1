package pro.sky.home_work_collections1.service;

import pro.sky.home_work_collections1.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Double sumOfSalariesByDepartment(int department);
    Double maxDepartmentSalary(int department);

    Double minDepartmentSalary(int department);

    List<Employee> getDepartmentsEmployee(int department);

    Map<Integer, List<Employee>> employeesByDepartment();
}
