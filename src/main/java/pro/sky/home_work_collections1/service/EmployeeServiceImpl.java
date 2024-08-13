package pro.sky.home_work_collections1.service;

import org.springframework.stereotype.Service;
import pro.sky.home_work_collections1.exceptions.EmployeeAlreadyAddedException;
import pro.sky.home_work_collections1.exceptions.EmployeeNotFoundException;
import pro.sky.home_work_collections1.exceptions.EmployeeStorageIsFullException;
import pro.sky.home_work_collections1.model.Employee;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    private static final int EMPLOYEE_LIMIT = 10;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    public EmployeeServiceImpl(Map<String, Employee> employees) {
        this.employees = employees;
    }

    public Map<String, Employee> getEmployees() throws NullPointerException {
        if (employees.isEmpty()) {
            throw new NullPointerException();
        }
        return employees;
    }

    public Employee addNewEmployee(String firstName, String lastName, int department, double salary) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        if (employees.size() >= EMPLOYEE_LIMIT) {
            throw new EmployeeStorageIsFullException();
        }
        Employee newEmployee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(newEmployee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(newEmployee.getFullName(), newEmployee);
        return newEmployee;
    }
    public Employee addNewEmployee(Employee employee) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        if (employees.size() >= EMPLOYEE_LIMIT) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }



    public Employee deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee deletableEmployee = new Employee(firstName, lastName);
        if (!employees.containsKey(deletableEmployee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(deletableEmployee.getFullName());
    }

    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee goalEmployee = new Employee(firstName, lastName);
        if (employees.containsKey(goalEmployee.getFullName())) {
            return employees.get(goalEmployee.getFullName());
        } else throw new EmployeeNotFoundException();
    }


}
