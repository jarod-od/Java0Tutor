package by.java_intro.algorithmization_2.many_dim9;

/**
 *  9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. 
 * Определить, какой  столбец содержит максимальную сумму. 
 */
public class Main {

    public static void main(String[] args) {

        final int M = 5, N = 5;
        
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

        System.out.println("Sum of elements in each column: ");
        long max = Long.MIN_VALUE;
        int maxColumn = 0;
        for (int j = 0; j < a[0].length; j++) {
            int s = 0;
            for (int i = 0; i < a.length; i++) {
                s+= a[i][j];
            }
            System.out.print(s + " ");
            if (max < s) {
                max = s;
                maxColumn = j;
            }
        }
        System.out.println();

        System.out.println("Max sum in column: " + maxColumn);
    }
}