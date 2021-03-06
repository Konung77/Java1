package geekbrains.lesson1;

public class lesson1 {
    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte a = 12;
        short b = 34;
        int c = 56;
        long d = 78;
        float e = 90.1f;
        double f = 123.456;
        char g = 'G';
        boolean h = false;

        // Далее идёт проверка написанных методов
        System.out.println(m1(12.34f, 56.78f, 90.12f, 34.56f));

        if (m2(5, 12)) System.out.println("Сумма чисел попадает в заданный интервал");

        IsPositive(45);

        if (m3(-3)) System.out.println("Второе число отрицательное");

        m4 ("Вася");

        LeapYear(2018);
        LeapYear(2000);
        LeapYear(1900);
        LeapYear(2020);
    }

    // 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    public static float m1(float a, float b, float c, float d){
        return (a * (b + (c / d)));
    }

    // 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    // если да – вернуть true, в противном случае – false;
    public static boolean m2 (int a, int b) { return (((a+b) >= 10) && ((a+b) <= 20)); }

    // 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
    // положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
    public static void IsPositive (int a){
        if (a >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }

    // 6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
    public static boolean m3 (int a){
        return (a < 0);
    }

    // 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public static void m4 (String name){
        System.out.println("Привет, "+name+"!");
    }

    // 8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void LeapYear (int a){
        if ((a%4 > 0) || ((a%100 == 0) && (a%400 != 0))) System.out.println(a+" - невисокосный год");
        else System.out.println(a+" - високосный год");
    }
}
