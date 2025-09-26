# Лабораторна робота №3 Бермічев Володимир ЦК-31
## Тема: Управління потоком виконання
### Хід роботи

#### 1. Повторити теоретичні відомості

#### 2. Виконати три завдання з таблиці 2 відповідно до свого варіанту у таблиці 1.
- Кожне завдання має бути реалізовано як окремий клас.
- Кожен клас має складатись щонайменше з двох методів:
- public static void main(String[] agrs) - точка входу. Містить код, що кілька разів
  знаходить результат завдання при різних значеннях аргументів та параметрів. Для
  перевірки мають бути присутні як дозволені так і заборонені комбінації аргументів та
  параметрів.
- Метод, що реалізує задане завдання. Метод має перевіряти аргументи і параметри
  функції та у разі їх помилковості аварійно закінчувати свою роботу шляхом
  викидання стандартного виключення IllegalArgumentException (дивись приклад). В
  жодному разі цей метод не повинен напряму взаємодіяти з користувачем через
  консоль або інший UI (ніколи не змішуйте бізнес-логіку та користувацький
  інтерфейс).
- Клас може містити інші допоміжні методи.
#### 3. Відповісти на контрольні питання

#### Умови: Варіант 2 - формули 2,7,12
[![image.png](https://i.postimg.cc/8zs4WGG6/image.png)](https://postimg.cc/tsQFQLYq)
[![image.png](https://i.postimg.cc/d1cjzTy2/image.png)](https://postimg.cc/7CXzzhXh)
[![image.png](https://i.postimg.cc/8ctdJKn4/image.png)](https://postimg.cc/tnnn85bn)

#### Виконання: Код
### 1.
```Java
public class zavd1_f2 {
    public static void main(String[] args) {
        printResults(-1.0, 2.0, 3);
        printResults(-2.0, 1.0, 5);
        printResults(-0.5, 4.0, 10);
        printResults(-1.0, 1.0, 25);
        printResults(-1.0, 1.0, 2);
        printResults(-1.0, 1.0, 26);
        printResults(1.0, 1.0, 5);    // t > 0
        printResults(-1.0, -1.0, 5);  // s < 0
        printResults(-1.0, 0.0, 5);   // s = 0
    }

    public static double calculateSeries(double t, double s, int k) {
        if (k <= 2 || k > 25) {
            throw new IllegalArgumentException("k повинен бути в діапазоні (2, 25]: " + k);
        }
        if (t >= 0) {
            throw new IllegalArgumentException("t має бути від'ємним, щоб ln(-t·i) було визначено: " + t);
        }
        if (s <= 0) {
            throw new IllegalArgumentException("s повинно бути додатнім: " + s);
        }

        double sum = 0.0;

        for (int i = 1; i <= k; i++) {
            double arg1 = -t * i;
            if (arg1 <= 0) {
                throw new IllegalArgumentException("Аргумент для ln повинен бути додатним: -t·i = " + arg1);
            }

            double arg2 = s / (i * i);
            if (arg2 < 0) {
                throw new IllegalArgumentException("Аргумент для sqrt повинен бути невід'ємним: s/i^2 = " + arg2);
            }

            double term = Math.log(arg1) * Math.cos(Math.sqrt(arg2));
            sum += term;
        }

        return sum;
    }

    static void printResults(double t, double s, int k) {
        System.out.print("t:" + t + " s:" + s + " k:" + k + " result:");
        try {
            System.out.println(calculateSeries(t, s, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
```
### Результат виконання:
[![image.png](https://i.postimg.cc/0Q5bMkRg/image.png)](https://postimg.cc/f3Fw1hR5)

### 2.
```Java
public class zavd2_f7 {
    public static void main(String[] args) {
        printResults(1.0, 1);
        printResults(2.0, 2);
        printResults(Math.E, 1);
        printResults(Math.E, 2);
        printResults(1.0, 3);
        printResults(2.0, 5);
        printResults(Math.PI, 10);
        printResults(0.0, 1);    // ln(0)
        printResults(-1.0, 2);   // ln(-1)
        printResults(1.0, 0);    // i = 0
        printResults(1.0, -1);   // i < 0
    }

    public static double calculateFunction(double t, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("i повинно бути додатним: " + i);
        }

        if (i == 1 || i == 2) {
            if (t <= 0) {
                throw new IllegalArgumentException("t повинно бути додатним для ln(t): " + t);
            }
            return Math.log(t);
        } else { // i > 2
            double sum = 0.0;
            double sinT = Math.sin(t);

            for (int k = 1; k <= i; k++) {
                sum += sinT / k;
            }
            return sum;
        }
    }

    static void printResults(double t, int i) {
        System.out.print("t:" + t + " i:" + i + " result:");
        try {
            System.out.println(calculateFunction(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
```
### Результат виконання:
[![image.png](https://i.postimg.cc/8cjc4Zzt/image.png)](https://postimg.cc/4HRXNbt9)

### 3.
```Java
public class zavd3_f12 {
    public static void main(String[] args) {
        printResults(0.1);
        printResults(0.01);
        printResults(0.001);
        printResults(0.0001);
        printResults(0.00001);
        printResults(1.0);
        printResults(0.5);
        printResults(0.0);      // ε = 0 - should throw exception
        printResults(-0.01);    // ε < 0 - should throw exception
        printResults(Double.NaN);  // ε = NaN - should throw exception
    }

    public static double calculateInfiniteSeries(double epsilon) {
        if (epsilon <= 0 || Double.isNaN(epsilon) || Double.isInfinite(epsilon)) {
            throw new IllegalArgumentException("Епсілон повинен додатним і скінченним: " + epsilon);
        }

        double sum = 0.0;
        double term;
        int i = 1;

        do {
            term = 1.0 / (i * (i + 1.0));
            sum += term;
            i++;

            // Safety check to prevent infinite loops (though this series converges well)
            if (i > 1000000) {
                throw new IllegalArgumentException("Розрахунок перевищив максимальну кількість ітерацій");
            }
        } while (Math.abs(term) >= epsilon);

        return sum;
    }

    static void printResults(double epsilon) {
        System.out.print("ε:" + epsilon + " result:");
        try {
            double result = calculateInfiniteSeries(epsilon);
            System.out.println(result + " (theoretical limit: 1.0, diff: " +
                    Math.abs(1.0 - result) + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
```
### Результат виконання:
[![image.png](https://i.postimg.cc/RVJqnp80/image.png)](https://postimg.cc/vcMGJhGR)

# Контрольні питання
## 1. Що таке структурне програмування?

Структурне програмування - це парадигма програмування, що використовує лише три базові управляючі конструкції (послідовність,
розгалуження, цикл) та уникає оператора goto для створення читабельного та зрозумілого коду з чіткою логічною структурою.

## 2. Назвіть основні конструкції структурного програмування.

Основні конструкції: послідовність (виконання команд одна за одною), розгалуження (if-else, switch), цикли (for, while,
do-while), підпрограми (методи/функції), блоки коду в фігурних дужках.

## 3. Назвіть основні принципи структурного програмування.

Основні принципи: один вхід і один вихід для кожного блоку коду, використання лише базових управляючих конструкцій,
декомпозиція складних задач на простіші підзадачі, уникнення goto та безумовних переходів.

## 4. Поясніть, чому в більшості мов програмування не радять використовувати оператор GOTO, а в мові Java його взагалі немає?

Оператор goto створює заплутаний код з непередбачуваними переходами, ускладнює відлагодження та розуміння логіки програми,
порушує принципи структурного програмування - замість нього використовують структурні конструкції, які забезпечують чіткий потік виконання.

## 5. Що таке спагеті-код?

Спагеті-код - це погано структурований код з безладними заплутаними переходами, зазвичай через надмірне використання goto, який важко
читати, налагоджувати та підтримувати через заплутану логіку виконання.

## 6. Що таке проектування зверху-вниз? В чому його переваги?

Проектування зверху-вниз - це метод розробки, коли складну задачу розбивають на менші підзадачі, які далі деталізують до
елементарних операцій.
Переваги: легше планування, краще розуміння структури, простіше тестування окремих частин.

## 7. Що таке область видимості ідентифікатора?

Область видимості ідентифікатора - це частина програми, де змінна, метод чи клас доступні для використання, визначається
місцем оголошення та може бути локальною (в методі/блоці), класовою або пакетною.

## 8. Що таке блок? Як блоки впливають на область видимості?

Блок - це група операторів, об'єднана фігурними дужками. Змінні, оголошені в блоці, видимі лише в цьому блоці та вкладених
блоках, що забезпечує інкапсуляцію та уникнення конфліктів імен.

## 9. Наведіть приклади, у яких випадках краще використовувати наступні оператори та конструкції: if, if-else, ланцюги if-else if -else if..., switch, тернарна умовна операція ?:

If - для простої перевірки одної умови, if-else - вибір між двома варіантами, ланцюги if-else if - перевірка кількох
взаємовиключних умов послідовно, switch - вибір з багатьох варіантів за значенням, тернарний оператор - короткий запис
простого if-else для присвоєння значення.

## 10. Наведіть приклади, у яких випадках краще використовувати наступні оператори та конструкції: while, do-while, for

While - коли невідома кількість ітерацій і умова перевіряється спочатку, do-while - коли потрібно виконати код принаймні
один раз, for - коли відома кількість ітерацій або є чітка послідовність кроків з ініціалізацією, умовою та інкрементом.

## 11. Чим оператор break відрізняється від оператора continue?

Break припиняє виконання циклу повністю та передає управління наступному оператору після циклу, continue пропускає
поточну ітерацію та переходить до наступної ітерації того ж циклу.

## 12. Навіщо у мові Java є мітки, якщо немає goto?

Мітки в Java потрібні для керування вкладеними циклами - break та continue можуть посилатися на мітку для виходу з
конкретного циклу, а не лише з найближчого.

## 13. До якого результату призведе виконання наступного фрагменту коду? Перевірте. Поясніть.
```Java
boolean a = false;
boolean b = false;
if (a=false) {
System.out.println(&quot;a is false&quot;);
}
if (b=true) {
System.out.println(&quot;b is true&quot;);
}
if (a=b) {
System.out.println(&quot;a = b&quot;);
}
```
[![image.png](https://i.postimg.cc/nz0fdmRz/image.png)](https://postimg.cc/S22PRnpF)
Вивело "b is true" та "a = b". Код має помилку - використано оператор присвоєння = замість порівняння ==, тому a=false
присвоює false і повертає false (умова не виконується), b=true присвоює true і повертає true, a=b присвоює значення b (true) змінній a і повертає true.

## 14. До якого результату призведе виконання наступного фрагменту коду? Перевірте. Поясніть.
```Java
int a = 1;
a++;
++a;
switch(a) {
case 1: System.out.println(&quot;1&quot;);
case 2: System.out.println(&quot;2&quot;);
case 3: System.out.println(&quot;3&quot;);
case 4: System.out.println(&quot;4&quot;);
}
```
[![image.png](https://i.postimg.cc/P5YGg930/image.png)](https://postimg.cc/0zkHmWqC)
Виведе "3" та "4", після a++ та ++a змінна a дорівнює 3, в switch відсутні break, тому виконання продовжується з case 3 до кінця блоку.

## 15. До якого результату призведе виконання наступного фрагменту коду (true/false)? Перевірте. Поясніть.
```Java
double sum = 0;
// Let&#39;s find: 1 + 1/2 + 1/3 + 1/4 + 1/5 + ...
for(int i=1; i&lt;10; i++) {
sum = sum + 1/i;
}
System.out.println(sum &gt; 1);
```
[![image.png](https://i.postimg.cc/sxvqwNG6/image.png)](https://postimg.cc/30Qtw9Bm)
Результат false, у циклі виконується цілочисельне ділення 1/i, яке для всіх i>1 дає 0, тому sum залишається 1.0
(лише 1/1 = 1), що не більше за 1.

