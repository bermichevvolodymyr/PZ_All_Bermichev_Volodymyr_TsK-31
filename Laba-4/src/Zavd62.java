import java.util.Arrays;
import java.util.Random;

public class Zavd62
{
    public int[] transformArray(int[] array) {
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
        Zavd62 obj = new Zavd62();
        //Random rn = new Random();
        //int[] arr = new int[10];
        //for (int i = 0; i < arr.length; i++) {
        //    arr[i] = rn.nextInt(100);
        //}
        //System.out.println(Arrays.toString(arr));

        int[] test1 = {10, 20, 5, 15};
        System.out.println("Тест 1: " + java.util.Arrays.toString(test1));
        System.out.println("Мінімальний елемент: 5");
        System.out.println("Результат: " + java.util.Arrays.toString(obj.transformArray(test1)));
        System.out.println();

        try {
            int[] test8 = {};
            System.out.println("Порожній масив");
            obj.transformArray(test8);
        } catch (IllegalArgumentException e) {
            System.out.println("Виняток: " + e.getMessage());
            System.out.println();
        }

        // null масив
        try {
            System.out.println("Null масив");
            obj.transformArray(null);
        } catch (NullPointerException e) {
            System.out.println("Виняток: " + e.getMessage());
        }
    }
}
