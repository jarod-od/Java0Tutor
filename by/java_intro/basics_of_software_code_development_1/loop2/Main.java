package by.java_intro.basics_of_software_code_development_1.loop2;

import java.util.Scanner;

/**
 * 2. Вычислить значения функции на отрезке [а,b] c шагом h: 
 *        x,  x > 2 
 * y = {              }
 *       -x,  x < = 2
 */
public class Main {
    static final int NUM_COUNT = 3;
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        double[] x = new double[NUM_COUNT];
        while (true) {
            try {
                System.out.println("Input a, b, h: ");
                Scanner s = new Scanner(System.in);
                for (int i = 0; i < NUM_COUNT; i++) {
                    x[i] = s.nextDouble();
                }
                System.out.println("a = " + x[0] + ", b = " + x[1] + ", h = " + x[2]);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        
        double c = x[0];
        double y = 0;
        while (c < x[1]) {
            if (c > 2) {
                y = c;
            } else {
                y = 0 - c;
            }
            c += x[2];
            c = Math.floor(c * 100000000) / 100000000;
            System.out.println("y(" + c + ") = " + y);
        }
    }

}