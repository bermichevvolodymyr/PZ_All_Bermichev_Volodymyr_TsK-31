public class zavd3_f12 {
    public static void main(String[] args) {
        printResults(0.1);
        printResults(0.01);
        printResults(0.001);
        printResults(0.0001);
        printResults(0.00001);
        printResults(1.0);
        printResults(0.5);
        printResults(0.0);      // ε = 0 - should throw exception
        printResults(-0.01);    // ε < 0 - should throw exception
        printResults(Double.NaN);  // ε = NaN - should throw exception
    }

    public static double calculateInfiniteSeries(double epsilon) {
        if (epsilon <= 0 || Double.isNaN(epsilon) || Double.isInfinite(epsilon)) {
            throw new IllegalArgumentException("Епсілон повинен додатним і скінченним: " + epsilon);
        }

        double sum = 0.0;
        double term;
        int i = 1;

        do {
            term = 1.0 / (i * (i + 1.0));
            sum += term;
            i++;

            if (i > 1000000) {
                throw new IllegalArgumentException("Розрахунок перевищив максимальну кількість ітерацій");
            }
        } while (Math.abs(term) >= epsilon);

        return sum;
    }

    static void printResults(double epsilon) {
        System.out.print("ε:" + epsilon + " result:");
        try {
            double result = calculateInfiniteSeries(epsilon);
            System.out.println(result + " (theoretical limit: 1.0, diff: " +
                    Math.abs(1.0 - result) + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}

