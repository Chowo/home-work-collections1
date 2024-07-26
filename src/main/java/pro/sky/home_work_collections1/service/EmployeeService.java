package pro.sky.home_work_collections1.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.home_work_collections1.exceptions.EmployeeAlreadyAddedException;
import pro.sky.home_work_collections1.exceptions.EmployeeNotFoundException;
import pro.sky.home_work_collections1.exceptions.EmployeeStorageIsFullException;
import pro.sky.home_work_collections1.exceptions.WrongInputException;
import pro.sky.home_work_collections1.model.Employee;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final Map<String, Employee> employees;
    private static final int EMPLOYEE_LIMIT = 5;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public Employee addNewEmployee(String firstName, String lastName, int department, double salary) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        if (employees.size() >= EMPLOYEE_LIMIT) {
            throw new EmployeeStorageIsFullException();
        }
        Employee newEmployee = new Employee(StringUtils.capitalize(firstName),
                StringUtils.capitalize(lastName),
                department,
                salary);
        if (employees.containsKey(newEmployee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        String validChars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        if (StringUtils.containsOnly(firstName, validChars) && StringUtils.containsOnly(lastName, validChars)) {
            employees.put(newEmployee.getFullName(), newEmployee);
            return newEmployee;
        } else {
            throw new WrongInputException();
        }
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
            return goalEmployee;
        } else throw new EmployeeNotFoundException();
    }


}
