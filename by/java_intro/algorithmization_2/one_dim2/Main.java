package by.java_intro.algorithmization_2.one_dim2;

import java.util.Scanner;

public class Main {
    
    static final int SEQ_SIZE = 20;
    
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        double z;
        while (true) {
            try {
                System.out.println("Input Z: ");
                Scanner s = new Scanner(System.in);
                z = s.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        double[] A = new double[SEQ_SIZE];
        int k = 0;
        System.out.println("Array A: ");
        for (int i = 0; i < SEQ_SIZE; i++) {
            A[i] = Math.random() * (z * 2);
            System.out.print((int)(A[i] * 100)/100. + " ");
            if (A[i] > z) {
                A[i] = z;
                k++;
            }
        }
        System.out.println();
        System.out.println("New array A: ");
        for (double i : A) {
            System.out.print((int)(i * 100)/100. + " ");
        }
        System.out.println();
        System.out.println("Replaces count : " + k);
    }
}