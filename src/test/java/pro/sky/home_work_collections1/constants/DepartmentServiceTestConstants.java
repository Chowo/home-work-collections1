package pro.sky.home_work_collections1.constants;

import pro.sky.home_work_collections1.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentServiceTestConstants {
    public static final Employee IVANOV = new Employee("Ivan", "Ivanov", 1, 50000.9);
    public static final Employee PETROV = new Employee("Petr", "Petrov", 2, 55000.0);
    public static final Employee SIDOROV = new Employee("Nikolai", "Sidorov", 1, 70000.1);
    public static final Employee SMIRNOV = new Employee("Oleg", "Smirnov", 2, 85000.0);

    static Map<String, Employee> map1 = new HashMap<>();
    {
        map1.put(IVANOV.getFullName(), IVANOV);
        map1.put(PETROV.getFullName(), PETROV);
        map1.put(SIDOROV.getFullName(), SIDOROV);
        map1.put(SMIRNOV.getFullName(), SMIRNOV);
    }

    public static final Map<String, Employee> EMPLOYEE_MAP = Map.of(IVANOV.getFullName(), IVANOV, PETROV.getFullName(), PETROV, SIDOROV.getFullName(), SIDOROV,SMIRNOV.getFullName(), SMIRNOV);
    public static final List<Employee> EMPLOYEE_LIST = List.of(IVANOV, PETROV, SIDOROV, SMIRNOV);

    public static final Map<Integer, List<Employee>> EMPLOYEES_BY_DEPARTMENT = EMPLOYEE_MAP.values().stream().collect(Collectors.groupingBy(Employee::getDepartment));
}
