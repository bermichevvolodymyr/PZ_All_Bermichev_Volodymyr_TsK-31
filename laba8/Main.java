package laba8;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Створення даних
        Employee director = new Employee("Ivan", "Petrov", 10000);
        Firm firm = new Firm("TechCorp", director);

        Department d1 = new Department("IT", new Employee("Oleh", "Sydorenko", 15000));
        d1.addEmployee(new Employee("Maksym", "Ivanov", 12000));
        d1.addEmployee(new Employee("Taras", "Bondar", 11000));

        Department d2 = new Department("HR", new Employee("Olena", "Koval", 11000));
        d2.addEmployee(new Employee("Irina", "Poliak", 9000));
        // Додамо дублікат, щоб перевірити роботу Set (він не повинен додатись)
        d2.addEmployee(new Employee("Irina", "Poliak", 9000));

        firm.addDepartment(d1);
        firm.addDepartment(d2);

        // Завдання 1 (Iterator raw)
        System.out.println("1. Максимальна зарплата: " + Zavd1.findMaxSalary(firm));

        // Завдання 2 (for-each)
        Department problem = Zavd2.findDepartment(firm);
        System.out.println("2. Відділ, де працівник отримує більше начальника: " +
                (problem != null ? problem.getName() : "немає"));

        // Завдання 3 (Iterator typed + Set return)
        System.out.println("3. Список всіх унікальних працівників (Set):");
        for (Employee e : Zavd3.listAll(firm)) {
            System.out.println("   - " + e);
        }

        // Завдання Creative (Map)
        System.out.println("\n4. Бюджет зарплат по відділах (Map):");
        Map<String, Double> budgets = ZavdMap.getDepartmentSalaryBudget(firm);
        for (Map.Entry<String, Double> entry : budgets.entrySet()) {
            System.out.println("   Відділ " + entry.getKey() + ": " + entry.getValue() + " грн");
        }
    }
}