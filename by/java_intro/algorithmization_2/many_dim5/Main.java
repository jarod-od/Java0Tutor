package by.java_intro.algorithmization_2.many_dim5;

import java.util.Scanner;

/**
 *  5. Сформировать квадратную матрицу порядка  n по заданному образцу( n - четное):  
 *  1   1   1   ...   1   1   1
 *  2   2   2   ...   2   2   0
 *  3   3   3   ...   3   0   0
 *  .   .   .   .     .   .   .
 *  n-1 n-1 0   ...   0   0   0
 *  n   0   0   ...   0   0   0
 */
public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        int n;
        while (true) {
            try {
                System.out.println("Input n (even): ");
                Scanner s = new Scanner(System.in);
                n = s.nextInt();
                if (n % 2 != 0) {
                    throw new Exception();
                }
                System.out.println("n = " + n);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        
        int[][] a = new int[n][n];
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (j >= n - i) {
                    a[i][j] = 0;
                } else {
                    a[i][j] = i + 1;
                }
            }
        }

        System.out.println("Matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}