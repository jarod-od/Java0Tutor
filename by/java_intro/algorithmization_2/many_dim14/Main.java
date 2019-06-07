package by.java_intro.algorithmization_2.many_dim14;

/**
 *  14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, 
 * причем в каждом столбце число  единиц равно номеру столбца. 
 */
public class Main {

    public static void main(String[] args) {

        final int N = 10, M = 10;
        
        int[][] a = new int[N][M];
        
        for (int j = 0; j < a[0].length; j++) {
            int z = j;
            for (int i = 0; i < a.length; i++) {
                if (z == 0) {
                    a[i][j] = 0;
                } else if (a.length - i == z){
                    a[i][j] = 1;
                    z--;
                } else {
                    a[i][j] = (int)(Math.random() * 2);
                    if (a[i][j] == 1) {
                        z--;
                    }
                }
                
            }
        }

        System.out.println("Matrix A: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }
}