package by.java_intro.algorithmization_2.many_dim8;

import java.util.Scanner;

/**
 *  8. В числовой матрице поменять местами два столбца любых столбца, 
 * т. е. все элементы одного столбца поставить  на соответствующие им позиции другого, 
 * а его элементы второго переместить в первый. Номера столбцов вводит  пользователь с клавиатуры. 
 */
public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        final int M = 5, N = 5;
        int c1, c2;
        while (true) {
            try {
                System.out.println("Input 2 columns num (< 5): ");
                Scanner s = new Scanner(System.in);
                c1 = s.nextInt();
                c2 = s.nextInt();
                if (c1 < 0 || c2 < 0 || c1 > 4 || c2 > 4) {
                    throw new Exception();
                }
                System.out.println("c1 = " + c1 + ", c2 = " + c2);
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

        int[] temp = new int[M];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i][c1];
        }

        for (int i = 0; i < a.length; i++) {
            a[i][c1] = a[i][c2];
        }

        for (int i = 0; i < a.length; i++) {
            a[i][c2] = temp[i];
        }

        System.out.println("New matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}