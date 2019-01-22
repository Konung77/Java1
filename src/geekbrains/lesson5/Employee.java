package geekbrains.lesson5;

// * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
public class Employee {
    String FIO;
    String position;
    String email;
    String phone;
    float salary;
    int age;

    // * Конструктор класса должен заполнять эти поля при создании объекта;
    // Не понятно, заполнять сам какими-то значениями по умолчанию или заполнять заданными значениями
    public Employee(String FIO, String position, String email, String phone, float salary, int age){
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    // * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    void PrintData(){
        System.out.println("Ф.И.О. сотрудника: " + this.FIO);
        System.out.println("Должность: " + this.position);
        System.out.println("Email: " + this.email);
        System.out.println("Телефон: " + this.phone);
        System.out.println("Зарплата: " + this.salary +  " рублей");
        System.out.println("Возраст: " + this.age + " лет");
    }
}
