public class zavd2_f7 {
    public static void main(String[] args) {
        printResults(1.0, 1);
        printResults(2.0, 2);
        printResults(Math.E, 1);
        printResults(Math.E, 2);
        printResults(1.0, 3);
        printResults(2.0, 5);
        printResults(Math.PI, 10);
        printResults(0.0, 1);    // ln(0)
        printResults(-1.0, 2);   // ln(-1)
        printResults(1.0, 0);    // i = 0
        printResults(1.0, -1);   // i < 0
    }

    public static double calculateFunction(double t, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("i повинно бути додатним: " + i);
        }

        if (i == 1 || i == 2) {
            if (t <= 0) {
                throw new IllegalArgumentException("t повинно бути додатним для ln(t): " + t);
            }
            return Math.log(t);
        } else { // i > 2
            double sum = 0.0;
            double sinT = Math.sin(t);

            for (int k = 1; k <= i; k++) {
                sum += sinT / k;
            }
            return sum;
        }
    }

    static void printResults(double t, int i) {
        System.out.print("t:" + t + " i:" + i + " result:");
        try {
            System.out.println(calculateFunction(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
