package by.java_intro.algorithmization_2.decomp12;

import java.util.Arrays;

/**
 *  12. Даны натуральные числа К и  N. Написать метод(методы) формирования массива А, 
 * элементами которого являются числа, сумма цифр которых равна К и которые не большее N. 
 */
public class Main {

    public static void main(String[] args) {
        int K = 10;
        int N = 100;

        System.out.println("K = " + K + ", N = " + N);

        int[] a = getArray(K, N);

        System.out.println("Array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] getArray(int K, int N) {
        int[] t = new int[N];
        int count = 0;
        for(int i = 1; i <= t.length; i++) {
            if (getNumeralsSum(i) == K) {
                t[count] = i;
                count++;
            }
        }

        return Arrays.copyOf(t, count);
    }

    private static int getNumeralsSum(int a) {
        int sum = 0;
        while(a > 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
}

