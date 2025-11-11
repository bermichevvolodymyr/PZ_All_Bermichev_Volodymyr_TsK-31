import java.util.Arrays;

public class Zavd2 {
    public int sumElementsGreaterThan3(int[] array) {
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
        Zavd2 obj=new Zavd2();
        int[] test1 = {1, 2, 4, 5, 3, 6, 7, 0};
        System.out.println("Тест 1: " + Arrays.toString(test1));
        System.out.println("Сума елементів > 3: " + obj.sumElementsGreaterThan3(test1));
        System.out.println();

        // Пустий масив
        try {
            int[] test6 = {};
            System.out.println("Порожній масив");
            obj.sumElementsGreaterThan3(test6);
        } catch (IllegalArgumentException e) {
            System.out.println("Виняток: " + e.getMessage());
            System.out.println();
        }

        // Null масив
        try {
            System.out.println("Null масив");
            obj.sumElementsGreaterThan3(null);
        } catch (NullPointerException e) {
            System.out.println("Виняток: " + e.getMessage());
        }
    }
}
