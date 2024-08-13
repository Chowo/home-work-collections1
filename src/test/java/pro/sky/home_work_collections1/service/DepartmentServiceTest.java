package pro.sky.home_work_collections1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.home_work_collections1.model.Employee;
import pro.sky.home_work_collections1.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static pro.sky.home_work_collections1.constants.DepartmentServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl out;



    @Test
    void should_throw_NullPointerException() {
        assertThrows(NullPointerException.class,()->out.getDepartmentsEmployee(3));
    }

    @Test
    void verify_that_it_can_return_list_of_employees() {
        when(employeeService.getEmployees()).
                thenReturn(EMPLOYEE_MAP);
        assertIterableEquals(new ArrayList<>(List.of(SIDOROV,IVANOV)), out.getDepartmentsEmployee(1));
    }
    @Test
    void return_sum_of_salaries_by_department() {
        when(employeeService.getEmployees()).
                thenReturn( EMPLOYEE_MAP);
        assertEquals((IVANOV.getSalary() + SIDOROV.getSalary()), out.sumOfSalariesByDepartment(1));
    }
    @Test
    void sum_return_0_when_there_is_no_asked_number_department() {
        when(employeeService.getEmployees()).
                thenReturn( EMPLOYEE_MAP);
        assertEquals(0.0, out.sumOfSalariesByDepartment(3));
    }
    @Test
    void return_max_salary_by_department() {
        when(employeeService.getEmployees()).
                thenReturn( EMPLOYEE_MAP);
        assertEquals(SIDOROV.getSalary(), out.maxDepartmentSalary(1));
    }
    @Test
    void max_return_0_when_there_is_no_asked_number_department() {
        when(employeeService.getEmployees()).
                thenReturn( EMPLOYEE_MAP);
        assertEquals(0.0, out.maxDepartmentSalary(3));
    }
    @Test
    void return_min_salary_by_department() {
        when(employeeService.getEmployees()).
                thenReturn( EMPLOYEE_MAP);
        assertEquals(PETROV.getSalary(), out.minDepartmentSalary(2));
    }
    @Test
    void min_return_0_when_there_is_no_asked_number_department() {
        when(employeeService.getEmployees()).
                thenReturn( EMPLOYEE_MAP);
        assertEquals(0.0, out.minDepartmentSalary(3));
    }
    @Test
    void return_map_of_employees_by_department() {
        when(employeeService.getEmployees()).
                thenReturn( EMPLOYEE_MAP);
        assertEquals(EMPLOYEES_BY_DEPARTMENT, out.employeesByDepartment());
    }


}
