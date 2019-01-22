package geekbrains.lesson3;

import java.util.Scanner;

// 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
// "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
// "pineapple", "pumpkin", "potato"};
//При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
//apple – загаданное
//apricot - ответ игрока
//ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//Для сравнения двух слов посимвольно, можно пользоваться:
//String str = "apple";
//str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//Играем до тех пор, пока игрок не отгадает слово
//Используем только маленькие буквы
public class task2 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int num = (int)(Math.random()*(words.length-1));
        String rand_word = words[num];
        String word;
        char[] result = new char[15];
        System.out.println("Ваша задача угадать слово.");
        while (true) {
            System.out.println("Введите слово:");
            word = scanner.nextLine();
            if (rand_word.equals(word)) {
                System.out.println("Вы угадали!");
                break;
            }
            else {
                for (int i = 0; i < 15; i++) result[i] = '#';
                for (int i = 0; (i < rand_word.length()) && (i < word.length()); i++) {
                    if (rand_word.charAt(i) == word.charAt(i)) result[i] = word.charAt(i);
                }
                System.out.println("Неверно. Показываю буквы, стоящие на своих местах: " + String.valueOf(result));
            }
        }
        scanner.close();
    }
}
