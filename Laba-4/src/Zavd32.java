public class Zavd32 {
    public static int sumEvenOnOddPositions(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int sum = 0;
        int index = 0;

        // Перевірка непарності індекса й парності елементу
        for (int element : array) {
            if (index % 2 != 0 && element % 2 == 0) {
                sum += element;
            }
            index++;
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] test1 = {1, 4, 3, 6, 5, 8, 7};
        System.out.println("Тест 1: " + java.util.Arrays.toString(test1));
        System.out.println("Індекси непарні (1,3,5): елементи [4, 6, 8]");
        System.out.println("Сума парних на непарних позиціях: " + sumEvenOnOddPositions(test1));
        System.out.println();

        // Нема парних на непарних
        int[] test2 = {2, 1, 4, 3, 6, 5};
        System.out.println("Тест 2: " + java.util.Arrays.toString(test2));
        System.out.println("Індекси непарні (1,3,5): елементи [1, 3, 5] - всі непарні");
        System.out.println("Сума парних на непарних позиціях: " + sumEvenOnOddPositions(test2));
        System.out.println();

        int[] test3 = {2, 4, 6, 8, 10};
        System.out.println("Тест 3: " + java.util.Arrays.toString(test3));
        System.out.println("Індекси непарні (1,3): елементи [4, 8]");
        System.out.println("Сума парних на непарних позиціях: " + sumEvenOnOddPositions(test3));
        System.out.println();

        int[] test4 = {-1, -4, 3, -6, 5, 10};
        System.out.println("Тест 4: " + java.util.Arrays.toString(test4));
        System.out.println("Індекси непарні (1,3,5): елементи [-4, -6, 10]");
        System.out.println("Сума парних на непарних позиціях: " + sumEvenOnOddPositions(test4));
        System.out.println();

        // 1 елемент
        int[] test5 = {5};
        System.out.println("Тест 5: " + java.util.Arrays.toString(test5));
        System.out.println("Немає елементів на непарних індексах");
        System.out.println("Сума парних на непарних позиціях: " + sumEvenOnOddPositions(test5));
        System.out.println();

        // Два елемента
        int[] test6 = {1, 8};
        System.out.println("Тест 6: " + java.util.Arrays.toString(test6));
        System.out.println("Індекс непарний (1): елемент [8]");
        System.out.println("Сума парних на непарних позиціях: " + sumEvenOnOddPositions(test6));
        System.out.println();

        // Пустий
        try {
            int[] test7 = {};
            System.out.println("Тест 7: порожній масив");
            sumEvenOnOddPositions(test7);
        } catch (IllegalArgumentException e) {
            System.out.println("Виняток: " + e.getMessage());
            System.out.println();
        }

        // Null масив
        try {
            System.out.println("Тест 8: null масив");
            sumEvenOnOddPositions(null);
        } catch (NullPointerException e) {
            System.out.println("Виняток: " + e.getMessage());
        }
    }
}
