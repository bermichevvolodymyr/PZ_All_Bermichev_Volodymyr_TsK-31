# Лабораторна робота №6 Бермічев Володимир ЦК-31
## Тема: 
### String

#### 1. Ознайомитись з API класу String. Особливу увагу звернути на методи:
- split
- toCharArray
- toLowerCase
- toUpperCase
#### 2. Виконати завдання з таблиці 2 відповідно до свого варіанту у таблиці 1.
- Кожне завдання має бути реалізовано як окремий клас.
- Кожен клас має складатись щонайменше з двох методів:
- public static void main(String[] agrs) - точка входу. Містить код, що кілька разів
  знаходить результат завдання при різних значеннях аргументів та параметрів. Для
  перевірки мають бути присутні як дозволені так і заборонені комбінації аргументів та
  параметрів.
- Метод, що реалізує задане завдання. Метод має перевіряти аргументи та у разі їх
  помилковості аварійно закінчувати свою роботу шляхом викидання стандартного
  виключення IllegalArgumentException або NullPointerException (дивись л/р №3). В
  жодному разі цей метод не повинен напряму взаємодіяти з користувачем через
  консоль або інший UI (ніколи не змішуйте бізнес-логіку та користувацький
  інтерфейс).
- Клас може містити інші допоміжні методи.
#### 3. Відповісти на контрольні питання

#### Умови: Варіант 2 - завдання 2,8
[![Snimok-ekrana-2025-11-06-170715.png](https://i.postimg.cc/nz7ck8mn/Snimok-ekrana-2025-11-06-170715.png)](https://postimg.cc/YGrHrs8P)
[![Snimok-ekrana-2025-11-06-170808.png](https://i.postimg.cc/SxsSPY9d/Snimok-ekrana-2025-11-06-170808.png)](https://postimg.cc/nCyfjz09)

#### Виконання: Код
### 2.
```Java
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
```
### Результат виконання:
[![Snimok-ekrana-2025-11-06-170933.png](https://i.postimg.cc/tCgGRQ4L/Snimok-ekrana-2025-11-06-170933.png)](https://postimg.cc/4njSw0t5)

### 8.
```Java
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

```
### Результат виконання:
[![Snimok-ekrana-2025-11-06-171029.png](https://i.postimg.cc/8PY9173m/Snimok-ekrana-2025-11-06-171029.png)](https://postimg.cc/svpwmg3M)

# Контрольні питання
## 1. Що таке immutable об’єкт? Для чого об’єкти класу String зробили імутабельними? Чому клас String задекларований як final?
Immutable об’єкт - це об’єкт, стан якого не можна змінити після створення. Клас String зроблено імутабельним, щоб 
забезпечити безпеку, кешування (пул рядків) і стабільність при багатопоточності. Клас String оголошено як final, щоб 
ніхто не міг його успадкувати і порушити ці властивості.

## 2. Що таке регулярні вирази? Наведіть приклади регулярних виразів.
Регулярні вирази - це шаблони для пошуку або перевірки тексту за певними правилами. Наприклад: \\d+ - одна або більше цифр,
\\s+ - один або більше пробілів, [A-Za-z]+ - послідовність літер.

## 3. В чому полягає різниця між оператором «==» та методом «equals()»?
Оператор == порівнює посилання на об’єкти (чи вказують вони на ту саму область пам’яті), а метод equals() порівнює 
зміст об’єктів. Для рядків слід використовувати equals(), бо == може дати false, навіть якщо тексти однакові.

## 4. Для чого потрібні класи StringBuilder та StringBuffer?
StringBuilder і StringBuffer використовуються для ефективного створення та зміни рядків. Вони дозволяють змінювати
вміст без створення нових об’єктів. StringBuilder швидший, але не синхронізований; StringBuffer повільніший, зате 
безпечний у багатопотоковому середовищі.

## 5. Яким чином простіше всього прибрати пробіли на початку та кінці об’єкту String?
Щоб прибрати пробіли на початку і в кінці рядка, використовують метод trim(), який видаляє всі пробіли, табуляції та
переноси рядків з обох кінців об’єкта String.


