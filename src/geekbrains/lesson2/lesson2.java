package geekbrains.lesson2;

import java.util.Arrays;

public class lesson2 {
    public static void main(String[] args) {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] vect1 = new int[]{1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1};
        for (int i = 0; i < vect1.length; i++) {
            vect1[i] = (vect1[i] == 0) ? 1 : 0;
        }
        // Проверка
        System.out.println("1)");
        System.out.println(Arrays.toString(vect1));

        // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] vect2 = new int[8];
        for (int i = 0; i < vect2.length; i++) {
            vect2[i] = i*3;
        }
        // Проверка
        System.out.println("2)");
        System.out.println(Arrays.toString(vect2));

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] vect3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < vect3.length; i++) {
            if (vect3[i] < 6) vect3[i] *= 2;
        }
        // Проверка
        System.out.println("3)");
        System.out.println(Arrays.toString(vect3));

        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] matr1 = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int len = matr1.length;
        for (int i = 0; i < len; i++) {
            matr1[i][i] = 1;
            matr1[i][len-1-i] = 1;
        }
        // Проверка
        System.out.println("4)");
        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(matr1[i]));
        }

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        // В условии не оговаривался тип массива, сделана реализация для целочисленного
        int[] vect4 = {34, 12, 145, 8, 234, 5, 1034, 789};
        int min = vect4[0];
        int max = vect4[0];
        for (int i: vect4) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        // Проверка
        System.out.println("5)");
        System.out.println(Arrays.toString(vect4));
        System.out.println("Минимальный элемент массива: "+ min+", максимальный: "+max);

        // Проверка
        System.out.println("6)");
        int[] vect5 = {1, 1, 1, 2, 1};
        System.out.println((isEqualParts(vect5)) ? "Массив делится на равные части" : "Массив не делится на равные части");
        int[] vect6 = {2, 1, 1, 2, 1};
        System.out.println((isEqualParts(vect6)) ? "Массив делится на равные части" : "Массив не делится на равные части");

        // Проверка
        System.out.println("7)");
        int[] vect7 = {1, 2, 3, 4, 5};
        shift(vect7, 2);
        System.out.println(Arrays.toString(vect7));
    }

    // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
    // checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.
    public static boolean isEqualParts (int[] a) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < a.length; i++) {
            right += a[i];
        }
        for (int i = 0; i < a.length-1; i++) {
            left += a[i];
            right -= a[i];
            if (left == right) return true;
        }
        return false;
    }

    // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // В условии не оговаривался тип массива, сделана реализация для целочисленного
    // Кроме того предполагается, что при положительном n элементы массива сдвигаются вправо, при отрицательном - влево
    public static void shift (int[] a, int n) {
        int b;
        int len = a.length-1;
        n = n%(len+1); // На случай, если n больше длины массива
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                b = a[len];
                for (int j = len; j > 0; j--) {
                    a[j] = a[j-1];
                }
                a[0] = b;
            }
        }
        else if (n < 0) {
            for (int i = 0; i < -n; i++) {
                b = a[0];
                for (int j = 0; j < len; j++) {
                    a[j] = a[j + 1];
                }
                a[len] = b;
            }
        }
        return;
    }
}
