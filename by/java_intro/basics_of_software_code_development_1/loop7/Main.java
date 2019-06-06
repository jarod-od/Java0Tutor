package by.java_intro.basics_of_software_code_development_1.loop7;

import java.util.Scanner;

/**
 * 7. Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.  m и n вводятся с клавиатуры. 
 */
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        long m = 0, n = 0;
        
        while (true) {
            try {
                System.out.println("Input m, n: ");
                Scanner s = new Scanner(System.in);
                m = s.nextLong();
                n = s.nextLong();
                System.out.println("m = " + m + ", n = " + n);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        
        long x = m + 1;

        while (x < n) {
            printDeviders(x);
            x++;
        }
    }

    private static void printDeviders(long x) {
        long d = 2;
        boolean isDevidersExist = false;
        while (d < x / 2 + 1) {
            if (x % d == 0) {
                if (!isDevidersExist) {
                    isDevidersExist = true;
                    System.out.println("Deviders of " + x + " :");
                    System.out.println(d);
                } else {
                    System.out.println(d);
                }
            }
            d++;
        }
        if (!isDevidersExist) {
            System.out.println(x + " has no deviders");
        }
    }

}