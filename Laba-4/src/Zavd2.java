public class Zavd2 {
    public static int sumElementsGreaterThan3(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3) {
                sum += array[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 4, 5, 3, 6, 7, 0};
        System.out.println("Тест 1: " + java.util.Arrays.toString(test1));
        System.out.println("Сума елементів > 3: " + sumElementsGreaterThan3(test1));
        System.out.println();

        int[] test2 = {1, 2, 3, 0, -1, 3};
        System.out.println("Тест 2: " + java.util.Arrays.toString(test2));
        System.out.println("Сума елементів > 3: " + sumElementsGreaterThan3(test2));
        System.out.println();

        int[] test3 = {10, 20, 5, 4};
        System.out.println("Тест 3: " + java.util.Arrays.toString(test3));
        System.out.println("Сума елементів > 3: " + sumElementsGreaterThan3(test3));
        System.out.println();

        int[] test4 = {-5, 100, 4, -10, 50};
        System.out.println("Тест 4: " + java.util.Arrays.toString(test4));
        System.out.println("Сума елементів > 3: " + sumElementsGreaterThan3(test4));
        System.out.println();

        // Один елемент > 3
        int[] test5 = {5};
        System.out.println("Тест 5: " + java.util.Arrays.toString(test5));
        System.out.println("Сума елементів > 3: " + sumElementsGreaterThan3(test5));
        System.out.println();

        // Пустий масив
        try {
            int[] test6 = {};
            System.out.println("Тест 6: порожній масив");
            sumElementsGreaterThan3(test6);
        } catch (IllegalArgumentException e) {
            System.out.println("Виняток: " + e.getMessage());
            System.out.println();
        }

        // Null масив
        try {
            System.out.println("Тест 7: null масив");
            sumElementsGreaterThan3(null);
        } catch (NullPointerException e) {
            System.out.println("Виняток: " + e.getMessage());
        }
    }
}
