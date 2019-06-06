package by.java_intro.algorithmization_2.one_dim3;

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
        int o = 0, z = 0, p = 0;
        System.out.println("Array A: ");
        for (int i = 0; i < n; i++) {
            A[i] = Math.random() * 50 - 25;
            System.out.print((int)(A[i] * 100)/100. + " ");
            if (A[i] > 0) {
                p++;
            } else if (A[i] < 0) {
                o++;
            } else {
                z++;
            }
        }
        System.out.println();
        System.out.println("Positive : " + p + ", Negative : " + o + ", Zero :" + z);
    }
}