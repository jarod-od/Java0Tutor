package by.java_intro.basics_of_software_code_development_1.cond4;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через  отверстие. 
 */
public class Main {
    static final int NUM_COUNT = 3;
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        double[] x = new double[NUM_COUNT];
        double A = 0, B = 0;
        while (true) {
            try {
                System.out.println("Input A, B, x, y, z: ");
                Scanner s = new Scanner(System.in);
                A = s.nextDouble();
                B = s.nextDouble();
                System.out.println("A = " + A + ", B = " + B);
                for (int i = 0; i < NUM_COUNT; i++) {
                    x[i] = s.nextDouble();
                }
                System.out.println("x = " + x[0] + ", y = " + x[1] + ", z = " + x[2]);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        Arrays.sort(x);
        double a = x[0];
        double b = x[1];
        if ((a < A && b < B) || (a < B && b < A)) {
            System.out.println("pass");
        } else {
            System.out.println("not pass");
        }
    }

}