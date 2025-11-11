public class Zavd32 {
    public int sumEvenOnOddPositions(int[] array) {
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
        Zavd32 obj = new Zavd32();
        int[] test1 = {1, 4, 3, 6, 5, 8, 7};
        System.out.println("Тест 1: " + java.util.Arrays.toString(test1));
        System.out.println("Індекси непарні (1,3,5): елементи [4, 6, 8]");
        System.out.println("Сума парних на непарних позиціях: " + obj.sumEvenOnOddPositions(test1));
        System.out.println();

        // Пустий
        try {
            int[] test7 = {};
            System.out.println("Порожній масив");
            obj.sumEvenOnOddPositions(test7);
        } catch (IllegalArgumentException e) {
            System.out.println("Виняток: " + e.getMessage());
            System.out.println();
        }

        // Null масив
        try {
            System.out.println("Null масив");
            obj.sumEvenOnOddPositions(null);
        } catch (NullPointerException e) {
            System.out.println("Виняток: " + e.getMessage());
        }
    }
}
