package by.java_intro.algorithmization_2.many_dim3;

import java.util.Scanner;

/**
 * 3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы. 
 */
public class Main {

    public static void main(String[] args) {
        final int M = 10, N = 10; 

        int k, p;
        while (true) {
            try {
                System.out.println("Input k, p ( < 10): ");
                Scanner s = new Scanner(System.in);
                k = s.nextInt();
                p = s.nextInt();
                if (k >= 10 || p >= 10) {
                    throw new Exception();
                }
                System.out.println("k = " + k + ", p = " + p);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        
        int[][] a = new int[M][N];
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int)(Math.random() * 100);
            }
        }

        System.out.println("Matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Line " + k + " : ");
        for (int j = 0; j < a[k].length; j++) {
            System.out.print(a[k][j] + " ");
        }
        System.out.println();

        System.out.println("Column " + p + " : ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i][p] + " ");
        }
        System.out.println();
    }
}