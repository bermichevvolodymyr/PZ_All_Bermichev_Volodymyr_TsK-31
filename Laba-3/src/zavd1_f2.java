public class zavd1_f2 {

        public static void main(String[] args) {
            double sum = 0;
            // Let's find: 1 + 1/2 + 1/3 + 1/4 + 1/5 + ...
            for(int i=1; i<10; i++) {
                sum = sum + 1/i;
            }
            System.out.println(sum > 1);
        }
    }