package by.java_intro.algorithmization_2.many_dim4;

import java.util.Scanner;

/**
 *  4. Сформировать квадратную матрицу порядка  n по заданному образцу( n - четное):  
 *  1   2   3   ...   n
 *  n   n-1 n-2 ...   1  
 *  1   2   3   ...   n
 *  .   .   .   .     .
 *  n   n-1 n-2 ...   1   
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
                if (i % 2 == 0) {
                    a[i][j] = j + 1;
                } else {
                    a[i][j] = n - j;
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