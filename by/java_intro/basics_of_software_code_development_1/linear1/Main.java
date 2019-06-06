package by.java_intro.basics_of_software_code_development_1.linear1;

import java.util.Scanner;

/**
 * 1. Найдите  значение функции: z = ( (a – 3 ) * b / 2) + c.
 */
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("Function: z = ((a - 3) * b / 2) + c");
        double[] x = new double[3];
        while (true) {
            try {
                System.out.println("Input a, b, c: ");
                Scanner s = new Scanner(System.in);
                for (int i = 0; i < 3; i++) {
                    x[i] = s.nextDouble();
                }
                System.out.println("a = " + x[0] + ", b = " + x[1] + ", c = " + x[2]);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        double z = ((x[0] - 3.) * x[1] / 2.) + x[2];
        System.out.println("z(a, b, c) = " + z);
    }
}