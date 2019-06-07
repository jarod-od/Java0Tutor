package by.java_intro.algorithmization_2.many_dim10;

/**
 *  10. Найти положительные элементы главной диагонали квадратной матрицы. 
 */
public class Main {

    public static void main(String[] args) {

        final int N = 5;
        
        int[][] a = new int[N][N];
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int)(Math.random() * 100 - 50);
            }
        }

        System.out.println("Matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("Positive elements of main diagonal: ");
        for (int i = 0; i < a.length; i++) {
            if (a[i][i] > 0) {
                System.out.print(a[i][i] + "  ");
            }
        }
        System.out.println();
    }
}