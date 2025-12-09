package laba8;

public class Zavd2 {
    public static Department findDepartment(Firm firm) {
        // Цикл for-each чудово працює з Set
        for (Department d : firm.getDepartments()) {
            double bossSalary = d.getBoss().getSalary();
            for (Employee e : d.getEmployees()) {
                if (e.getSalary() > bossSalary) {
                    return d;
                }
            }
        }
        return null;
    }
}