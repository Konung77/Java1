package geekbrains.lesson6;

// 4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
public class Animal {
    // 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
    // прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
    protected float run_limit;
    protected float jump_limit;
    protected float swim_limit;

    public Animal () {
        this.run_limit = 0;
        this.jump_limit = 0;
        this.swim_limit = 0;
    }

    public Animal (float run, float jump, float swim) {
        this.run_limit = run;
        this.jump_limit = jump;
        this.swim_limit = swim;
    }

    // 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
    // В качестве параметра каждому методу передается величина, означающая или длину препятствия
    // (для бега и плавания), или высоту (для прыжков).
    public boolean CanRun (int distance) {
        return (distance > this.run_limit) ? false : true;
    }

    public boolean CanJump (int distance) {
        return (distance > this.jump_limit) ? false : true;
    }

    public boolean CanSwim (int distance) {
        return (distance > this.swim_limit) ? false : true;
    }
}

// 1. Создать классы Собака и Кот с наследованием от класса Животное.
class Cat extends Animal {
    public Cat () {
        super (200, 2, 0);
    }

    public Cat (float run, float jump) {
        super (run, jump, 0);
    }
}

class Dog extends Animal {
    public Dog () {
        super (500, 0.5f, 10);
    }

    public Dog (float run) {
        super (run, 0.5f, 10);
    }

    public Dog (float run, float jump, float swim) {
        super (run, jump, swim);
    }
}

// 5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
class Pudel extends Dog {
    public Pudel() {
        super(400);
    }
}

class Ovcharka extends Dog {
    public Ovcharka() {
        super(600);
    }
}