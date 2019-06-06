package by.java_intro.basics_of_software_code_development_1.cond5;

import java.util.Scanner;

/**
 * 5. Вычислить значение функции:   
 *          x^2 - 3x + 9,  x <= 3 
 * F(x) = {                       }
 *          1 / (x^3 + 6), x > 3
 */
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        double x = 0;
        while (true) {
            try {
                System.out.println("Input x: ");
                Scanner s = new Scanner(System.in);
                x = s.nextDouble();
                System.out.println("x = " + x);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        double f = 0;
        if (x > 3) {
            f = 1. / (x * x * x + 6);
        } else {
            f = x * x - 3 * x + 9;
        }
        System.out.println("F(x) = " + f);
    }
}