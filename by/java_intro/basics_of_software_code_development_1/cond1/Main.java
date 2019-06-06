package by.java_intro.basics_of_software_code_development_1.cond1;

import java.util.Scanner;

/**
 * 1. Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли  он прямоугольным. 
 */
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int x = 0, y = 0;
        while (true) {
            try {
                System.out.println("Input x, y: ");
                Scanner s = new Scanner(System.in);
                x = s.nextInt();
                y = s.nextInt();
                System.out.println("x = " + x + " deg, y = " + y + " deg");
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        if (x + y > 180 || x < 0 || y < 0) {
            System.out.println("Triange does not exist");
        } else {
            System.out.println("Triange exists");
            if (x == 90 || y == 90 || x + y == 90) {
                System.out.println("Triange is right");
            } else {
                System.out.println("Triange is not right");
            }
        }
        
    }
}