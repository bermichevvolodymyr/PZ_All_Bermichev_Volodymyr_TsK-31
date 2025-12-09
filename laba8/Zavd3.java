package laba8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Zavd3 {
    // Повертаємо Set, щоб відповідати вимозі "замінити List на Set"
    public static Set<Employee> listAll(Firm firm) {
        Set<Employee> all = new HashSet<>();

        all.add(firm.getDirector());

        Iterator<Department> it = firm.getDepartments().iterator();   // типізований

        while (it.hasNext()) {
            Department d = it.next();
            all.add(d.getBoss());

            Iterator<Employee> w = d.getEmployees().iterator();       // типізований
            while (w.hasNext()) {
                all.add(w.next());
            }
        }
        return all;
    }
}