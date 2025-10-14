# Лабораторна робота №4 Бермічев Володимир ЦК-31
## Тема: 
### Масиви

#### 1. Повторити теоретичні відомості

#### 2. Виконати три завдання з таблиці 2 відповідно до свого варіанту у таблиці 1.
- В одному з завдань обов’язково має бути використаний цикл «for»
- В одному з завдань обов’язково має бути використаний цикл «for-each»
- Кожне завдання має бути реалізовано як окремий клас.
- Кожен клас має складатись щонайменше з двох методів:
- public static void main(String[] agrs) - точка входу. Містить код, що кілька разів
  знаходить результат завдання при різних значеннях аргументів та параметрів. Для
  перевірки мають бути присутні як дозволені так і заборонені комбінації аргументів та
  параметрів.
- Метод, що реалізує задане завдання. Метод має перевіряти аргументи та у разі їх
  помилковості аварійно закінчувати свою роботу шляхом викидання стандартного
  виключення IllegalArgumentException, NullPointerException або
  IndexOutOfBoundsException(дивись л/р №3).В жодному разі цей метод не повинен
  напряму взаємодіяти з користувачем через консоль або інший UI (ніколи не змішуйте
  бізнес-логіку та користувацький інтерфейс).
- Клас може містити інші допоміжні методи.
#### 3. Відповісти на контрольні питання

#### Умови: Варіант 2 - завдання 2,32,62
[![image.png](https://i.postimg.cc/90TYR3TK/image.png)](https://postimg.cc/8fp690Zm)
[![image.png](https://i.postimg.cc/kGrxdjZT/image.png)](https://postimg.cc/TL9yVcTb)
[![image.png](https://i.postimg.cc/xdcHNDVs/image.png)](https://postimg.cc/zLY34QBW)

#### Виконання: Код
### 1.
```Java
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
```
### Результат виконання:
[![image.png](https://i.postimg.cc/59qH0NFx/image.png)](https://postimg.cc/XXqN1W8h)

### 2.
```Java
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
```
### Результат виконання:
[![image.png](https://i.postimg.cc/0yJPzcHC/image.png)](https://postimg.cc/75DpcM4C)

### 3.
```Java
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
```
### Результат виконання:
[![image.png](https://i.postimg.cc/504hS3pL/image.png)](https://postimg.cc/f3PqwYGR)

# Контрольні питання
## 1. Чим змінна відрізняється від масиву
Змінна зберігає одне значення, масив зберігає множину значень одного типу з доступом через індекс. Змінна займає 
фіксований обсяг пам'яті залежно від типу, масив - динамічний обсяг залежно від кількості елементів.

## 2. Що таке стек? Що таке купа? Яка між ними різниця?
Стек - область пам'яті для локальних змінних та викликів методів, працює за принципом LIFO, швидкий, обмежений розміром, 
автоматично керований. Купа - область для динамічних об'єктів, керується garbage collector, більша за розміром, 
повільніша за доступом, зберігає дані доки є посилання.

## 3. Чи може змінна бути розташована у стеку? Безпосередньо у купі? В об’єкті у купі? Чи може масив бути розташований у стеку? Безпосередньо у купі? В об’єкті у купі?
Примітивна змінна може бути у стеку (локальна) та в об'єкті у купі (поле класу), але не безпосередньо у купі. Посилання 
на об'єкт може бути у стеку та в об'єкті у купі. Масив не може бути у стеку, тільки у купі безпосередньо або як поле об'єкта у купі.

## 4. Чим посилання на масив відрізняється від масиву? Чи може посилання на масив бути розташовано у стеку? Безпосередньо у купі? В об’єкті у купі?
Посилання на масив - це адреса масиву в пам'яті, сам масив - це об'єкт з даними у купі. Посилання може бути у стеку
(локальна змінна) або в об'єкті у купі (поле класу), але не безпосередньо у купі без контейнера.

## 5. Якщо масив складається з 10 комірок, які індекси мають перша та остання комірки?
Перша комірка має індекс 0, остання має індекс 9.

## 6. Що буде, якщо звернутися до неіснуючої комірки у масиві?
Викинеться виключення ArrayIndexOutOfBoundsException під час виконання програми.

## 7. При створенні нового масиву без явної ініціалізації усі його комірки будуть проініціалізовані: - спеціальними значеннями за замовчуванням? - довільними значеннями, що знаходяться в цей час у пам’яті, яку виділено під масив?
Спеціальними значеннями за замовчуванням - 0 для чисел, false для boolean, null для посилань. Java завжди ініціалізує пам'ять.

## 8. Як дізнатися номер першої та останньої комірки масиву, якщо відомо лише посилання на нього?
Перша комірка завжди має індекс 0, остання - array.length - 1. Властивість length повертає кількість елементів масиву.

## 9. Як змінити розмір масиву?
Масиви незмінного розміру, тому їх розмір не можна змінити. Треба створити новий масив потрібного розміру та скопіювати елементи через System.arraycopy або Arrays.copyOf.

## 10. Що відбувається з масивом при копіюванні посилання на нього?
Копіюється тільки посилання, сам масив залишається один у пам'яті. Обидва посилання вказують на той самий масив, зміни
через одне посилання видно через інше.

## 11. Що відбувається з масивом при втрачанні посилання на нього?
Масив стає недоступним для програми. Garbage collector виявить його як непотрібний об'єкт та звільнить пам'ять автоматично
під час наступної збірки сміття.

## 12. Чим відрізняються конструкції «for» та «for-each» при роботі з масивами? Які переваги та недоліки кожного з варіантів?
For дає доступ до індексу, можна змінювати елементи, йти у зворотному порядку, пропускати елементи, але довший синтаксис
та можливість помилки з індексами. For-each коротший, безпечніший, читабельніший, але тільки послідовний прохід, без доступу
до індексу, неможливо змінювати елементи примітивних типів.

## 13. Чи можна у масив «double[]» записати значення «int»? Чи можна у масив «int[]» записати значення «double»?
У масив double[] можна записати int, відбудеться автоматичне розширення типу. У масив int[] не можна записати double 
без явного приведення типу, бо втрачається точність - компілятор видасть помилку.