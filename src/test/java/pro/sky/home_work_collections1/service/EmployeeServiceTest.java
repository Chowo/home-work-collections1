package pro.sky.home_work_collections1.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.home_work_collections1.exceptions.EmployeeAlreadyAddedException;
import pro.sky.home_work_collections1.exceptions.EmployeeNotFoundException;
import pro.sky.home_work_collections1.exceptions.EmployeeStorageIsFullException;
import pro.sky.home_work_collections1.model.Employee;
import pro.sky.home_work_collections1.service.EmployeeService;
import pro.sky.home_work_collections1.service.EmployeeServiceImpl;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


public class EmployeeServiceTest {
    private EmployeeService out = new EmployeeServiceImpl();

    @BeforeEach
    void make_a_list_of_employees() {
        out.addNewEmployee("Максим", "Иванов", 1, 67852.36);
        out.addNewEmployee("Никита", "Петров", 1, 88745.72);
        out.addNewEmployee("Анна", "Николаева", 2, 79852.17);
        out.addNewEmployee("Вадим", "Смоляков", 3, 65887.53);
        out.addNewEmployee("Александр", "Никифоров", 2, 58442.45);
        out.addNewEmployee("Илана", "Владимирова", 2, 100456.87);
        out.addNewEmployee("Петр", "Графов", 3, 72454.79);
        out.addNewEmployee("Кирилл", "Смирнов", 1, 72454.79);
        out.addNewEmployee("Раиса", "Клементьева", 3, 85456.95);
    }

    @Test
    void should_return_nullPointerException() {
        out = new EmployeeServiceImpl();
        assertThrows(NullPointerException.class, out::getEmployees);
    }

    @Test
    void adding_should_throw_employeeAlreadyAddedException() {
        assertThrows(EmployeeAlreadyAddedException.class,()-> out.addNewEmployee("Никита", "Петров", 1, 88745.72));
    }
    @Test
    void adding_should_throw_StorageIsFullException() {
        out.addNewEmployee("Petr", "Petrov", 3, 79256.15);
        assertThrows(EmployeeStorageIsFullException.class,()-> out.addNewEmployee("Ivan", "Ivanov", 1, 100000.00));
    }
    @Test
    void should_throw_EmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,()-> out.findEmployee("Ivan", "Ivanov"));
    }
    @Test
    void deleting_should_throw_EmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,()-> out.deleteEmployee("Ivan", "Ivanov"));
    }
    @Test
    void verify_that_employee_is_added() {
        Employee comparableEmployee = new Employee("Petr", "Petrov", 3, 79256.15);
        assertEquals(out.addNewEmployee("Petr", "Petrov", 3, 79256.15), comparableEmployee);
    }

    @Test
    void verify_that_employee_was_deleted() {
        out.deleteEmployee("Петр", "Графов");
        assertDoesNotThrow(()-> out.addNewEmployee("Петр", "Графов", 3, 72454.79));
    }
    @Test
    void verify_that_employee_can_be_found() {
        Employee comparableEmployee = new Employee("Petr", "Petrov", 3, 79256.15);
        out.addNewEmployee("Petr", "Petrov", 3, 79256.15);
        assertEquals(out.findEmployee("Petr", "Petrov"), comparableEmployee);
    }




}
