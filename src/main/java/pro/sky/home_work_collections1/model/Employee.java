package pro.sky.home_work_collections1.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int department;
    private double salary;

    public Employee(String firstName, String lastName) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase(Locale.ROOT));
        this.lastName = StringUtils.capitalize(lastName.toLowerCase(Locale.ROOT));
    }
    public Employee(String firstName, String lastName, int department, double salary) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase(Locale.ROOT));
        this.lastName = StringUtils.capitalize(lastName.toLowerCase(Locale.ROOT));
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Employee employee = (Employee) object;
        return getFirstName().equals(employee.getFirstName()) &&
                getLastName().equals(employee.getLastName()) &&
                getDepartment() == employee.getDepartment() &&
                getSalary() == employee.getSalary();
    }

    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getDepartment(), getSalary());
    }

    public String toString() {
        return "Имя - " + getFirstName() +
                " Фамилия - " + getLastName() +
                "Отдел №" + getDepartment() +
                "зарплата - " + getSalary();
    }
}
