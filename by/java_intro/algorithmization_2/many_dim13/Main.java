package by.java_intro.algorithmization_2.many_dim13;

import java.util.Arrays;

/**
 *  13. Отсортировать столбцы матрицы по возрастанию и убыванию значений элементов. 
 */
public class Main {

    public static void main(String[] args) {

        final int N = 5, M = 5;
        
        int[][] a = new int[N][M];
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int)(Math.random() * 100);
            }
        }

        System.out.println("Matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

        int[] t = new int[a.length];
        for (int j = 0; j < a[0].length; j++) {
            for (int i = 0; i < a.length; i++) {
                t[i] = a[i][j];
            }

            Arrays.sort(t);

            for (int i = 0; i < a.length; i++) {
                a[i][j] = t[i];
            }
        }

        System.out.println("Sorted ascending matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
        
        for (int j = 0; j < a[0].length; j++) {
            for (int i = 0; i < a.length / 2; i++) {
                int r = a[i][j];
                a[i][j] = a[a[0].length - i - 1][j];
                a[a[0].length - i - 1][j] = r;
            }
        }

        System.out.println("Sorted descending matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

    }
}