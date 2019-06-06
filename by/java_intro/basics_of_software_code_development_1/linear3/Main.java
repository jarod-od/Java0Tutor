package by.java_intro.basics_of_software_code_development_1.linear3;

import java.util.Scanner;

/**
 * 3. Вычислить значение выражения по формуле (все переменные принимают действительные значения):  
 * (sin x + cos x) / (cos x - sin y) * tg xy
 */
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("Function: (sin x + cos y) / (cos x - sin y) * tg xy");
        double x = 0, y = 0;
        while (true) {
            try {
                System.out.println("Input x, y: ");
                Scanner s = new Scanner(System.in);
                x = s.nextDouble();
                y = s.nextDouble();
                System.out.println("x = " + x + " rad, y = " + y + " rad");
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        double z = (Math.sin(x) + Math.cos(y)) / (Math.sin(x) - Math.cos(y)) * Math.tan(x * y);
        System.out.println("Value = " + z);
    }
}