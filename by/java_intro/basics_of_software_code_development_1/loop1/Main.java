package by.java_intro.basics_of_software_code_development_1.loop1;

import java.util.Scanner;

/**
 * 1. Напишите программу, где пользователь вводит любое целое положительное число. 
 * А программа суммирует  все числа от 1 до введенного пользователем числа. 
 */
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        long x = 0;
        while (true) {
            try {
                System.out.println("Input x: ");
                Scanner s = new Scanner(System.in);
                x = s.nextLong();
                System.out.println("x = " + x);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        long s = 0;
        while (x > 0) {
            s += x;
            x--;
        }
        System.out.println("Sum = " + s);
    }
}