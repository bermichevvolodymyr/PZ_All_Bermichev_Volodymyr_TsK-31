package laba8;

import java.util.Iterator;

public class Zavd1 {
    public static double findMaxSalary(Firm firm) {
        double max = firm.getDirector().getSalary();

        // Нетипізований ітератор працює з Set так само як з List
        Iterator deps = firm.getDepartments().iterator();

        while (deps.hasNext()) {
            Department d = (Department) deps.next();

            if (d.getBoss().getSalary() > max)
                max = d.getBoss().getSalary();

            Iterator workers = d.getEmployees().iterator();

            while (workers.hasNext()) {
                Employee e = (Employee) workers.next();
                if (e.getSalary() > max)
                    max = e.getSalary();
            }
        }
        return max;
    }
}