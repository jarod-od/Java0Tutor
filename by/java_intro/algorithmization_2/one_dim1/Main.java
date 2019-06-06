package by.java_intro.algorithmization_2.one_dim1;

import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int n, k;
        while (true) {
            try {
                System.out.println("Input N, K: ");
                Scanner s = new Scanner(System.in);
                n = s.nextInt();
                k = s.nextInt(); 
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        int[] A = new int[n];
        int s = 0;
        System.out.println("Array A: ");
        for (int i = 0; i < n; i++) {
            A[i] = (int)(Math.random() * (k * 10));
            System.out.print(A[i] + " ");
            if (A[i] % k == 0) {
                s += A[i];
            }
        }
        System.out.println();
        System.out.println("Sum of multiples of " + k +" : " + s);
    }
}