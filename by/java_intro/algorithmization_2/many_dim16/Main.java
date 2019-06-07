package by.java_intro.algorithmization_2.many_dim16;

/**
 *  16. Магическим квадратом порядка n называется квадратная матрица размера n x n, 
 * составленная из чисел 1, 2, 3,  ..., n^2 так, что суммы по каждому столбцу, 
 * каждой строке и каждой из двух больших диагоналей равны между  собой. 
 * Построить такой квадрат. Пример магического квадрата порядка 3: 
 * 6 1 8
 * 7 5 3
 * 2 9 4
 */
public class Main {

    public static void main(String[] args) {

        final int N = 3;
        
        int[][] a = new int[N][N];

        int[] nums = new int[N * N];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        boolean isFound = false;

        do {

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = nums[i * a[i].length + j];
                }
            }

            if (isMagic(a)) {
                isFound = true;
                break;
            }

        } while (getNextPermutation(nums));
        
        if (isFound) {
            System.out.println("Magic matrix: ");
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.print(a[i][j] + "  ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Magic matrix not found");
        }
    }

    private static boolean isMagic(int[][] a) {
        int sum = (a.length * a.length + 1) * a.length / 2;

        for (int i = 0; i < a.length; i++) {
            int s = 0;
            for(int j = 0; j < a[i].length; j++) {
                s += a[i][j];
            }
            if (s != sum) {
                return false;
            }
        }

        for(int j = 0; j < a[0].length; j++) {
            int s = 0;
            for (int i = 0; i < a.length; i++) {
                s += a[i][j];
            }
            if (s != sum) {
                return false;
            }
        }

        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s += a[i][i]; 
        }
        if (s != sum) {
            return false;
        }

        s = 0;
        for (int i = 0; i < a.length; i++) {
            s += a[a.length - i - 1][i]; 
        }
        if (s != sum) {
            return false;
        }

        return true;
    }

    private static boolean getNextPermutation(int[] n) {

        int i = n.length - 2;
        while (i != -1 && n[i] >= n[i + 1]) {
            i--;
        }
        if (i == -1) {
            return false;
        }

        int k =  n.length - 1;
        while (n[i] >= n[k]) {
            k--;
        }

        swap(n, i, k);

        int l = i + 1, r = n.length - 1;
        while (l < r) {
            swap(n, l++, r--);
        }

        return true;
    }

    private static void swap(int[] n, int a, int b) {
        int t = n[a];
        n[a] = n[b];
        n[b] = t;
    }

}