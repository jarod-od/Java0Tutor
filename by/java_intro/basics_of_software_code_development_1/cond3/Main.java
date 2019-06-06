package by.java_intro.basics_of_software_code_development_1.cond3;

import java.util.Scanner;

/**
 * 3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.  
 */
public class Main {
    static final int NUM_COUNT = 3;
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        double[] x = new double[NUM_COUNT];
        double[] y = new double[NUM_COUNT];
        while (true) {
            try {
                System.out.println("Input x1, y1, x2, y2, x3, y3: ");
                Scanner s = new Scanner(System.in);
                for (int i = 0; i < NUM_COUNT; i++) {
                    x[i] = s.nextDouble();
                    y[i] = s.nextDouble();
                    int n = i + 1;
                    System.out.println("x" + n + " = " + x[i] + ", y" + n + " = " + y[i]);
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        /*
        a * x1 + b = y1
        b = y1 - a * x1
        a * x2 + y1 - a * x1 = y2
        a = (y2 - y1) / (x2 - x1)
        */
        double a = (y[1] - y[0]) / (x[1] - x[0]);
        double b = y[0] - a * x[0];

        double y3 = x[2] * a + b;

        System.out.println("a = " + a + ", b = " + b + ", y3 = " + y3);

        if (equals(y3, y[2])) {
            System.out.println("Points belong to one line");
        } else {
            System.out.println("Points do not belong to one line");
        }
    }

    private static boolean equals(double a, double b) {
        double e = 0.001;
        if (a > b - e && a < b + e) {
            return true;
        } else {
            return false;
        } 
    }

}