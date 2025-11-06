public class Zavd2 {

    // Метод перетворює ціле число у двійковий рядок
    public String intToBinaryString(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Число має бути невід’ємним");
        }
        return Integer.toBinaryString(i).toUpperCase();
    }

    public static void main(String[] args) {
        Zavd2 obj = new Zavd2();

        System.out.println(obj.intToBinaryString(21));   // 10101
        System.out.println(obj.intToBinaryString(0));    // 0
        System.out.println(obj.intToBinaryString(255));  // 11111111

        // Перевірка некоректного аргументу
        try {
            System.out.println(obj.intToBinaryString(-5));
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
