package by.java_intro.algorithmization_2.many_dim15;

/**
 *  15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
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

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (max < a[i][j]) {
                    max = a[i][j];
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] % 2 == 1) {
                    a[i][j] = max;
                }
            }
        }

        System.out.println("New matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

    }
}