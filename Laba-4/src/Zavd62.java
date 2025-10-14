public class Zavd62
{
    public static int[] transformArray(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        // мін ел
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        // новий масив
        int[] result = new int[array.length];

        if (min == 0) {
            // якщо мін = 0 то міняємо все на -10
            for (int i = 0; i < result.length; i++) {
                result[i] = -10;
            }
        } else {
            // ділимо ел на мін з них
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i] / min;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {10, 20, 5, 15};
        System.out.println("Тест 1: " + java.util.Arrays.toString(test1));
        System.out.println("Мінімальний елемент: 5");
        System.out.println("Результат: " + java.util.Arrays.toString(transformArray(test1)));
        System.out.println();

        int[] test2 = {-10, 20, -5, 30};
        System.out.println("Тест 2: " + java.util.Arrays.toString(test2));
        System.out.println("Мінімальний елемент: -10");
        System.out.println("Результат: " + java.util.Arrays.toString(transformArray(test2)));
        System.out.println();

        int[] test3 = {5, 0, 10, -3};
        System.out.println("Тест 3: " + java.util.Arrays.toString(test3));
        System.out.println("Мінімальний елемент: -3");
        System.out.println("Результат: " + java.util.Arrays.toString(transformArray(test3)));
        System.out.println();

        int[] test4 = {7, 7, 7, 7};
        System.out.println("Тест 4: " + java.util.Arrays.toString(test4));
        System.out.println("Мінімальний елемент: 7");
        System.out.println("Результат: " + java.util.Arrays.toString(transformArray(test4)));
        System.out.println();

        int[] test5 = {15};
        System.out.println("Тест 5: " + java.util.Arrays.toString(test5));
        System.out.println("Мінімальний елемент: 15");
        System.out.println("Результат: " + java.util.Arrays.toString(transformArray(test5)));
        System.out.println();

        int[] test6 = {0, 0, 0};
        System.out.println("Тест 6: " + java.util.Arrays.toString(test6));
        System.out.println("Мінімальний елемент: 0");
        System.out.println("Результат: " + java.util.Arrays.toString(transformArray(test6)));
        System.out.println();

        int[] test7 = {100, -2, 50, 200};
        System.out.println("Тест 7: " + java.util.Arrays.toString(test7));
        System.out.println("Мінімальний елемент: -2");
        System.out.println("Результат: " + java.util.Arrays.toString(transformArray(test7)));
        System.out.println();

        try {
            int[] test8 = {};
            System.out.println("Тест 8: порожній масив");
            transformArray(test8);
        } catch (IllegalArgumentException e) {
            System.out.println("Виняток: " + e.getMessage());
            System.out.println();
        }

        // null масив
        try {
            System.out.println("Тест 9: null масив");
            transformArray(null);
        } catch (NullPointerException e) {
            System.out.println("Виняток: " + e.getMessage());
        }
    }
}
