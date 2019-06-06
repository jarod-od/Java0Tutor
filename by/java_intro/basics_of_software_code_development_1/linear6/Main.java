package by.java_intro.basics_of_software_code_development_1.linear6;

import java.util.Scanner;

/**
 * 6. Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)  
 * принадлежит закрашенной области, и false — в противном случае:   
 */
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        double x = 0, y = 0;
        while (true) {
            try {
                System.out.println("Input x, y: ");
                Scanner s = new Scanner(System.in);
                x = s.nextDouble();
                y = s.nextDouble();
                System.out.println("x = " + x + ", y = " + y);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        if (isBelongFirst(x, y) || isBelongSecond(x, y)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        
    }
    private static boolean isBelongFirst(double x, double y) {
        if (x <= 2 && x >= -2 && y <= 4 && y >= 0) {
            return true;
        } else {
            return false;
        }
    }
    private static boolean isBelongSecond(double x, double y) {
        if (x <= 4 && x >= -4 && y <= 0 && y >= -3) {
            return true;
        } else {
            return false;
        }
    }
}