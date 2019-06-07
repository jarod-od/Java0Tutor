package by.java_intro.algorithmization_2.many_dim11;

/**
 *  11. Матрицу 10 x20 заполнить случайными числами от 0 до 15. 
 * Вывести на экран саму матрицу и номера строк, в  которых число 5 встречается три и более раз. 
 */
public class Main {

    public static void main(String[] args) {

        final int N = 10, M = 20;
        
        int[][] a = new int[N][M];
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int)(Math.random() * 15);
            }
        }

        System.out.println("Matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("Num of lines: ");
        for (int i = 0; i < a.length; i++) {
            int k = 0;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 5) {
                    k++;
                }
            }
            if (k > 2) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}