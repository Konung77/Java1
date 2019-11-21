package geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

// 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
public class Krestiki {
    private static final int size_x = 3;
    private static final int size_y = 3;
    private static char[][] field = new char[size_x][size_y];
    private static final char player_dot = 'X';
    private static final char comp_dot = 'O';
    private static final char empty_dot = '.';
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        InitField();
        PrintField();
        while (true) {
            PlayerTurn();
            PrintField();
            if (Win(player_dot)) {
                System.out.println("Вы победили. Поздравляю!");
                break;
            }
            if (FieldFull()) {
                System.out.println("Ничья!");
                break;
            }
            CompTurn();
            PrintField();
            if (Win(comp_dot)) {
                System.out.println("Компьютер выиграл. GAME OVER!");
                break;
            }
            if (FieldFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
        scanner.close();
    }

    public static void PrintField() {
        System.out.print(" |");
        for (int i = 0; i < size_x; i++) {
            System.out.print((i+1)+"|");
        }
        System.out.println(" X");
        for (int i = 0; i < size_x; i++) {
            System.out.print((i+1)+"|");
            for (int j = 0; j < size_y; j++) {
                System.out.print(field[i][j]+"|");
            }
            System.out.println("");
        }
        System.out.println("Y");
    }

    private static void InitField() {
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                field[i][j] = empty_dot;
            }
        }
    }

    private static boolean Available (int x, int y){
        if (x < 1 || x > size_x || y < 1 || y > size_y) return false;
        if (field[x-1][y-1] != empty_dot) return false;
        return true;
    }

    private static void PlayerTurn(){
        while (true) {
            System.out.println("Ваш ход. Введите координаты X,Y (1-" + size_x + ")");
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            if (Available(x, y)) {
                field[x - 1][y - 1] = player_dot;
                break;
            }
            else System.out.println("Недопустимый ход");
        }
    }

    private static void CompTurn(){
        int danger;
        System.out.println("Мой ход.");
        // 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
        for (int i = 0; i < size_x; i++) {
            danger = StringDanger(i);
            if (danger > 0) {
                field[i][danger] = comp_dot;
                return;
            }
            danger = ColumnDanger(i);
            if (danger > 0) {
                field[danger][i] = comp_dot;
                return;
            }
        }
        danger = Diag1Danger();
        if (danger > 0) {
            field[danger][danger] = comp_dot;
            return;
        }
        danger = Diag2Danger();
        if (danger > 0) {
            field[danger][size_x - 1 - danger] = comp_dot;
            return;
        }
        while (true) {
            int x = random.nextInt(size_x);
            int y = random.nextInt(size_y);
            if (Available(x+1, y+1)) {
                field[x][y] = comp_dot;
                return;
            }
        }
    }

    private static boolean FieldFull(){
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (field[i][j] == empty_dot) return false;
            }
        }
        return true;
    }

    // 2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
    private static boolean Win(char C){
        boolean _win;
        for (int i = 0; i < size_x; i++) {
            _win = true;
            for (int j = 0; j < size_y; j++) {
                _win = _win && (field[i][j] == C);
            }
            if (_win) return true;
        }
        for (int i = 0; i < size_x; i++) {
            _win = true;
            for (int j = 0; j < size_y; j++) {
                _win = _win && (field[j][i] == C);
            }
            if (_win) return true;
        }
        _win = true;
        for (int i = 0; i < size_x; i++) {
            _win = _win && (field[i][i] == C);
        }
        if (_win) return true;
        for (int i = 0; i < size_x; i++) {
            _win = _win && (field[i][size_x - 1 - i] == C);
        }
        return _win;
    }

    private static int StringDanger(int x) {
        int danger = 0;
        int count = 0;
        for (int i = 0; i < size_x; i++) {
            if (field[x][i] == player_dot) count++;
            else if (field[x][i] == comp_dot) return 0;
            else danger = i;
        }
        if (count == size_x-1) return danger;
        return 0;
    }

    private static int ColumnDanger(int x) {
        int danger = 0;
        int count = 0;
        for (int i = 0; i < size_x; i++) {
            if (field[i][x] == player_dot) count++;
            else if (field[i][x] == comp_dot) return 0;
            else danger = i;
        }
        if (count == size_x-1) return danger;
        return 0;
    }

    private static int Diag1Danger() {
        int danger = 0;
        int count = 0;
        for (int i = 0; i < size_x; i++) {
            if (field[i][i] == player_dot) count++;
            else if (field[i][i] == comp_dot) return 0;
            else danger = i;
        }
        if (count == size_x-1) return danger;
        return 0;
    }

    private static int Diag2Danger() {
        int danger = 0;
        int count = 0;
        for (int i = 0; i < size_x; i++) {
            if (field[i][size_x - i - 1] == player_dot) count++;
            else if (field[i][size_x - i - 1] == comp_dot) return 0;
            else danger = i;
        }
        if (count == size_x-1) return danger;
        return 0;
    }
}
