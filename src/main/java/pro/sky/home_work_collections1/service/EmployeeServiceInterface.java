package pro.sky.home_work_collections1.service;

import pro.sky.home_work_collections1.model.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    public List<Employee> getEmployees();

    public Employee addNewEmployee(String firstName, String lastName);

    public Employee deleteEmployee(String firstName, String lastName);

    public Employee findEmployee(String firstName, String lastName);

}
