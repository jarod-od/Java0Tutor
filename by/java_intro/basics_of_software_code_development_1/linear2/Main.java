package by.java_intro.basics_of_software_code_development_1.linear2;

import java.util.Scanner;

/**
 * 2. Вычислить значение выражения по формуле (все переменные принимают действительные значения):  
 * (b + sqrt(b^2 + 4ac)) / 2a - a^3 c + b ^ (-2)
 */
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("Function: (b + (b^2 + 4ac)^(0.5)) / (2a) - a^3*c + b^(-2)");
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
        double z = (x[1] + Math.sqrt(x[1] * x[1] + 4. * x[0] * x[2])) / (2. * x[0]) - x[0] * x[0] * x[0] * x[2] + 1. / (x[1] * x[1]);
        System.out.println("Value = " + z);
    }
}