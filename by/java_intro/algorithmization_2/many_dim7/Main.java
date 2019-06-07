package by.java_intro.algorithmization_2.many_dim7;

import java.util.Scanner;

/**
 *  7. Сформировать квадратную матрицу порядка N по правилу:  
 * 
 * A[I, J] = sin ((I^2 - J^2) / N) 
 * 
 */
public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        int n;
        while (true) {
            try {
                System.out.println("Input n: ");
                Scanner s = new Scanner(System.in);
                n = s.nextInt();
                System.out.println("n = " + n);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        
        double[][] a = new double[n][n];
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = Math.sin((double)(i * i - j * j) / n);
            }
        }

        System.out.println("Matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print((int)(a[i][j] * 1000) / 1000. + "   ");
            }
            System.out.println();
        }

        int k = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > 0) {
                    k++;
                }
            }
        }

        System.out.println("Positive elements count: " + k);

    }
}