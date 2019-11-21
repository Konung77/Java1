package geekbrains.lesson5;

public class Main5 {
    public static void main(String[] args) {
        // * Создать массив из 5 сотрудников
        Employee[] workers = new Employee[5];

        workers[0] = new Employee("Иванов Сидор Петрович", "Директор", "ivanov-sp@company.com",
                "8-901-234-56-70", 100000.12f,56);
        workers[1] = new Employee("Сидоренко Алевтина Макаровна", "Бухгалтер", "sidorenko-am@company.com",
                "8-901-234-56-71", 60000.23f, 43);
        workers[2] = new Employee("Петров Прохор Кузьмич", "Завхоз", "", "8-901-234-56-72",
                50000, 52);
        workers[3] = new Employee("Явин Семен Михайлович", "Программист", "javin-sm@company.com",
                "8-901-234-56-73", 40000, 28);
        workers[4] = new Employee("Земляникина Вера Сергеевна", "Секретарь", "zemlyanikina-vs@company.com",
                "8-901-234-56-74", 30000, 22);

        // * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        System.out.println("Информация о сотрудниках старше 40 лет:");
        System.out.println("");
        for (int i = 0; i < workers.length; i++) {
            if (workers[i].age > 40) workers[i].PrintData();
            System.out.println("");
        }
    }
}
