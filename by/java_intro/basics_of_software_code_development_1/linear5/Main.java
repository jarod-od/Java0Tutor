package by.java_intro.basics_of_software_code_development_1.linear5;

import java.util.Scanner;

/**
 * 5. Дано  натуральное число Т,  которое  представляет  длительность прошедшего  времени  в  секундах.  
 * Вывести  данное значение длительности в часах, минутах и секундах в следующей форме:  ННч ММмин SSc. 
 */
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int t = 0;
        while (true) {
            try {
                System.out.println("Input T: ");
                Scanner s = new Scanner(System.in);
                t = s.nextInt();
                System.out.println("T = " + t);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        int h = t / 3600;
        int m = (t - h * 3600) / 60;
        int s = t - h * 3600 - m * 60;
        System.out.println(h + "ч " + m + "мин " + s + "с");
    }
}