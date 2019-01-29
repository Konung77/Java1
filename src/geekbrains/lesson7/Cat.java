package geekbrains.lesson7;

//1. Расширить задачу про котов и тарелки с едой
public class Cat {
    String name; // имя (необязательное поле)
    private int appetite; // аппетит (сколько кот съедает за 1 раз)
    boolean full; // сытость

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = false; // изначально кот всегда голоден
    }

    //3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
    // Если коту удалось покушать (хватило еды), сытость = true
    //4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает,
    // то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) this.full = true;
    }
}

class Plate {
    private int food; // количество еды в миске

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("В миске " + food + "г еды");
    }

    //2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
    // (например, в миске 10 еды, а кот пытается покушать 15-20)
    public boolean decreaseFood(int food) {
        if (food > this.food) {
            System.out.println("Закончился корм.");
            return false;
        }
        this.food -= food;
        return true;
    }

    //6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    public void increaseFood (int food) {
        this.food += food;
    }
}

class Main {
    public static void main(String[] args) {
//5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
// и потом вывести информацию о сытости котов в консоль
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Barsik", 15);
        cats[1] = new Cat("Murzik", 20);
        cats[2] = new Cat("Pushok", 27);
        cats[3] = new Cat("Vasya", 25);
        cats[4] = new Cat("Muha", 32);
        Plate plate = new Plate(100);
        plate.info();
        System.out.println("Кормим всех котов.");
        for (int i = 0; i < cats.length; i++)
            cats[i].eat(plate);
        plate.info();
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].full) System.out.println("Кот "+cats[i].name+" сыт");
            else System.out.println("Кот "+cats[i].name+" голоден");
        }
        plate.increaseFood(50);
        System.out.println("В миску добавлен корм.");
        System.out.println("Кормим голодных котов.");
        for (int i = 0; i < cats.length; i++)
            if (!cats[i].full) cats[i].eat(plate);
        plate.info();
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].full) System.out.println("Кот "+cats[i].name+" сыт");
            else System.out.println("Кот "+cats[i].name+" голоден");
        }
    }
}
