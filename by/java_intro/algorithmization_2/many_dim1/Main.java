package by.java_intro.algorithmization_2.many_dim1;

/**
 * 1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего. 
 */
public class Main {

    public static void main(String[] args) {
        final int M = 10, N = 5; 
        
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

        System.out.println("Solution: ");
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 1) {
                if (a[i][0] > a[i][a[i].length - 1]) {
                    for (int j = 0; j < a[i].length; j++) {
                        System.out.print(a[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}