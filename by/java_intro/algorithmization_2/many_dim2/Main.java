package by.java_intro.algorithmization_2.many_dim2;

/**
 * 2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.  
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

        System.out.println("Solution: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i][i] + " ");
        }
    }
}