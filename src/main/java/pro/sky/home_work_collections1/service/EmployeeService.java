package pro.sky.home_work_collections1.service;

import org.springframework.stereotype.Service;
import pro.sky.home_work_collections1.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private List<Employee> employees;
    private static final int EMPLOYEE_LIMIT = 5;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee addNewEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        if (employees.size() >= EMPLOYEE_LIMIT) {
            throw new EmployeeStorageIsFullException();
        }
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee deletableEmployee = new Employee(firstName, lastName);
        if (!employees.contains(deletableEmployee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(deletableEmployee);
        return deletableEmployee;
    }

    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee goalEmployee = new Employee(firstName, lastName);
        if (employees.contains(goalEmployee)) {
            return goalEmployee;
        } else throw new EmployeeNotFoundException();
    }
}
