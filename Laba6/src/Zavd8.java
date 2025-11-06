public class Zavd8 {

    // Метод підраховує кількість чисел у рядку
    public int countNumbers(String sentence) {
        if (sentence == null) {
            throw new NullPointerException("Рядок не може бути null");
        }

        String[] tokens = sentence.split("\\s+");
        int count = 0;

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Zavd8 obj = new Zavd8();

        String s1 = "The user with the nickname koala757677 this month wrote 3 times more comments than croco181dile920 4 months ago";
        String s2 = "There are 12 apples and 34 bananas.";
        String s3 = "No numbers here";

        System.out.println(obj.countNumbers(s1)); // 2
        System.out.println(obj.countNumbers(s2)); // 2
        System.out.println(obj.countNumbers(s3)); // 0

        // Перевірка на null
        try {
            System.out.println(obj.countNumbers(null));
        } catch (NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
