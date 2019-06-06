package by.java_intro.algorithmization_2.one_dim6;

import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int n;
        while (true) {
            try {
                System.out.println("Input N: ");
                Scanner s = new Scanner(System.in);
                n = s.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        double[] A = new double[n];
        double s = 0;
        System.out.println("Array A: ");
        for (int i = 0; i < n; i++) {
            A[i] = Math.random() * 100;
            System.out.print((int)(A[i] * 100)/100. + " ");
            if (isSimple(i)) {
                s+= A[i];
            }
        }
        System.out.println();
        System.out.println("Sum of nums with simple index : " + (int)(s * 100)/100.);
    }
    private static boolean isSimple(int k) {
        if (k < 2) {
            return false;
        }
        for (int i = 2; i <= k / 2; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }
}