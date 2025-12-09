package laba8;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Department {
    private String name;
    private Employee boss;
    private Set<Employee> employees; // Зміна List -> Set

    public Department(String name, Employee boss) {
        this.name = name;
        this.boss = boss;
        this.employees = new HashSet<>(); // Зміна ArrayList -> HashSet
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public String getName() { return name; }

    public Employee getBoss() { return boss; }

    public Set<Employee> getEmployees() { return employees; } // Return Set

    // equals/hashCode для Department (хороший тон при використанні в Set)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}