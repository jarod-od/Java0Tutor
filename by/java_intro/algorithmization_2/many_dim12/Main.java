package by.java_intro.algorithmization_2.many_dim12;

import java.util.Arrays;

/**
 *  12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов. 
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

        for (int i = 0; i < a.length; i++) {
            Arrays.sort(a[i]);
        }

        System.out.println("Sorted ascending matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length / 2; j++) {
                int t = a[i][j];
                a[i][j] = a[i][a[i].length - j - 1];
                a[i][a[i].length - j - 1] = t;
            }
        }

        System.out.println("sorted descending matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

    }
}