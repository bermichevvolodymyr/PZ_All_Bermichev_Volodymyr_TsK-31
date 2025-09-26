public class zavd1_f2 {
    public static void main(String[] args) {
        printResults(-1.0, 2.0, 3);
        printResults(-2.0, 1.0, 5);
        printResults(-0.5, 4.0, 10);
        printResults(-1.0, 1.0, 25);
        printResults(-1.0, 1.0, 2);
        printResults(-1.0, 1.0, 26);
        printResults(1.0, 1.0, 5);    // t > 0
        printResults(-1.0, -1.0, 5);  // s < 0
        printResults(-1.0, 0.0, 5);   // s = 0
    }

    public static double calculateSeries(double t, double s, int k) {
        if (k <= 2 || k > 25) {
            throw new IllegalArgumentException("k повинен бути в діапазоні (2, 25]: " + k);
        }
        if (t >= 0) {
            throw new IllegalArgumentException("t має бути від'ємним, щоб ln(-t·i) було визначено: " + t);
        }
        if (s <= 0) {
            throw new IllegalArgumentException("s повинно бути додатнім: " + s);
        }

        double sum = 0.0;

        for (int i = 1; i <= k; i++) {
            double arg1 = -t * i;
            if (arg1 <= 0) {
                throw new IllegalArgumentException("Аргумент для ln повинен бути додатним: -t·i = " + arg1);
            }

            double arg2 = s / (i * i);
            if (arg2 < 0) {
                throw new IllegalArgumentException("Аргумент для sqrt повинен бути невід'ємним: s/i^2 = " + arg2);
            }

            double term = Math.log(arg1) * Math.cos(Math.sqrt(arg2));
            sum += term;
        }

        return sum;
    }

    static void printResults(double t, double s, int k) {
        System.out.print("t:" + t + " s:" + s + " k:" + k + " result:");
        try {
            System.out.println(calculateSeries(t, s, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
