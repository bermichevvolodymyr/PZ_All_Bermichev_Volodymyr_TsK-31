package laba8;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private double salary;

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return getFullName() + " | Salary = " + salary;
    }

    // Необхідно для HashSet: об'єкти вважаються однаковими, якщо поля співпадають
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, salary);
    }
}