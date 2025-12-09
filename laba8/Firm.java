package laba8;

import java.util.HashSet;
import java.util.Set;

public class Firm {
    private String name;
    private Employee director;
    private Set<Department> departments; // Зміна List -> Set

    public Firm(String name, Employee director) {
        this.name = name;
        this.director = director;
        this.departments = new HashSet<>(); // Зміна ArrayList -> HashSet
    }

    public void addDepartment(Department d) {
        departments.add(d);
    }

    public Employee getDirector() { return director; }

    public Set<Department> getDepartments() { return departments; } // Return Set
}