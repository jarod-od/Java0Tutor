package by.java_intro.basics_of_software_code_development_1.cond2;

import java.util.Scanner;

/**
 * 2. Найти max{min(a, b), min(c, d)}. 
 */
public class Main {
    static final int NUM_COUNT = 4;
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        double[] x = new double[NUM_COUNT];
        while (true) {
            try {
                System.out.println("Input a, b, c, d: ");
                Scanner s = new Scanner(System.in);
                for (int i = 0; i < NUM_COUNT; i++) {
                    x[i] = s.nextDouble();
                }
                System.out.println("a = " + x[0] + ", b = " + x[1] + ", c = " + x[2] + ", d = " + x[3]);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    
        System.out.println("max{min(a,b), min(c,d)} = " + max(min(x[0], x[1]), min(x[2], x[3])));
    }
    private static double min(double a, double b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }
    private static double max(double a, double b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}