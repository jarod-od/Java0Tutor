package by.java_intro.basics_of_software_code_development_1.linear4;

import java.util.Scanner;

/**
 * 4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). 
 * Поменять местами  дробную и целую части числа и вывести полученное значение числа. 
 */
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        double r = 0;
        while (true) {
            try {
                System.out.println("Input R: ");
                Scanner s = new Scanner(System.in);
                r = s.nextDouble();
                System.out.println("R = " + r);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        int h = (int)r;
        int l = (int)(r * 1000) % 1000;
        double z = l + h / 1000.;
        System.out.println("Value = " + z);
    }
}