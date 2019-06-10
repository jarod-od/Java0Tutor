package by.java_intro.algorithmization_2.decomp2;

/**
 *  2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел. 
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("NOD of 34, 51, 102, 272 is " + getNOD(34, 51, 102, 272) + " (17)");
    }

    private static int getNOD(int a, int b, int c, int d) {
        return getNOD(getNOD(getNOD(a, b), c), d);
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