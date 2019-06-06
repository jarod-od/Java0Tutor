package by.java_intro.basics_of_software_code_development_1.loop5;

import java.util.Scanner;

/**
 * 5.  Даны  числовой ряд  и некоторое  число  е. Найти  сумму тех  членов  ряда, модуль  которых больше  или  равен  заданному е. 
 * Общий член ряда имеет вид:
 * a[n] = 1 / 2^n + 1 / 3^n
 */
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        double e = 0;
        
        while (true) {
            try {
                System.out.println("Input e: ");
                Scanner s = new Scanner(System.in);
                e = s.nextDouble();
                System.out.println("e = " + e);
                break;
            } catch (Exception ex) {
                System.out.println("Invalid input");
            }
        }
        
        double a = 1. / 2. + 1. / 3.;
        double s = 0;
        long n = 1;
        while (a >= e) {
            s += a;
            n++;
            a = 1. / Math.pow(2., n) + 1. / Math.pow(3., n);
        }
        System.out.println("Sum = " + s);
    }

}