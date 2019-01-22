package geekbrains.lesson3;

import java.util.Scanner;

// 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
// При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
// После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
public class task1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PlayLevel(9);
        scanner.close();
    }

    private static void PlayLevel(int range) {
        int number = (int)(Math.random() * range);
        int counter = 0;
        System.out.println("Угадайте число от 0 до " + range + ". У Вас 3 попытки.");
        do (int i = 0; i < 3; i++) {
            int input_number = scanner.nextInt();
            if (input_number > number) {
                System.out.println("Загаданное число меньше");
            } else if (input_number < number) {
                System.out.println("Загаданное число больше");
            } else {
                System.out.println("Вы угадали");
                break;
            }
            counter++;
            if (counter == 3) System.out.println("Вы не угадали. Все попытки закончились.");
        } while (counter == 3);
    }
}
