package by.java_intro.algorithmization_2.decomp1;

/**
 *  1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух  натуральных чисел:
 * НОК(A,B) = A * B / НОД(A,B)
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("NOK of 34 and 52 is " + getNOK(34, 52) + " (884)");
        System.out.println("NOD of 34 and 52 is " + getNOD(34, 52) + " (2)");
        System.out.println("NOK of 34 and 51 is " + getNOK(34, 51) + " (102)");
        System.out.println("NOD of 34 and 51 is " + getNOD(34, 51) + " (17)");
    }

    private static int getNOK(int a, int b) {
        return a * b / getNOD(a, b);
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