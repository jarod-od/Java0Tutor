package by.java_intro.algorithmization_2.decomp6;

/**
 *  6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми. 
 */
public class Main {

    public static void main(String[] args) {
        final int N = 3;
        int[] a = new int[N];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 100 + 1);
        }

        System.out.println("Three numbers: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        if(areNumbersMutuallyPrime(a[0], a[1], a[2])) {
            System.out.println("Numbers are mutually prime");
        } else {
            System.out.println("Numbers are not mutually prime");
        }
    }

    private static boolean areNumbersMutuallyPrime(int a, int b, int c) {
        if (getNOD(a, b) == 1 && getNOD(a, c) == 1 && getNOD(b, c) == 1) {
            return true;
        } else {
            return false;
        }
    }

    private static int getNOD(int a, int b) {
        if (a == 0) {
            return b; 
        } else if (b == 0 || a == b) {
            return a;
        } else if (a == 1 || b == 1) {
            return 1;
        } else if (a % 2 == 0 && b % 2 == 0) {
            return 2 * getNOD(a / 2, b / 2);
        } else if (a % 2 == 0) {
            return getNOD(a / 2, b);
        } else if (b % 2 == 0) {
            return getNOD(a, b / 2);
        } else if (b > a) {
            return getNOD((b - a) / 2, a);
        } else {
            return getNOD((a - b) / 2, b);
        }
    }
    
}

