package laba8;

import java.util.HashMap;
import java.util.Map;

public class ZavdMap {
    /**
     * Повертає мапу, де ключ - назва відділу, а значення - сумарна зарплата всіх працівників (включно з шефом).
     */
    public static Map<String, Double> getDepartmentSalaryBudget(Firm firm) {
        Map<String, Double> budgetMap = new HashMap<>();

        for (Department d : firm.getDepartments()) {
            double totalSalary = d.getBoss().getSalary(); // Зарплата начальника

            for (Employee e : d.getEmployees()) {
                totalSalary += e.getSalary(); // Плюс зарплати працівників
            }

            budgetMap.put(d.getName(), totalSalary);
        }

        return budgetMap;
    }
}