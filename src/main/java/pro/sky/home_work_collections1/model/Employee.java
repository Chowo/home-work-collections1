package pro.sky.home_work_collections1.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
                getLastName().equals(employee.getLastName());
    }

    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    public String toString() {
        return "Имя - " + getFirstName() +
                "Фамилия - " + getLastName();
    }
}
