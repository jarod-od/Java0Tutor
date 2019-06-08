package by.java_intro.algorithmization_2.sort1;

import java.util.Scanner;

/**

 *  1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. 
 * Объединить их в  один  массив,  включив  второй  массив  между  k-м  и  (k+1)  -  м  элементами  первого,  
 * при  этом  не  используя  дополнительный массив. 
 */
public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        final int N = 20, M = 10;

        int k;
        while (true) {
            try {
                System.out.println("Input k ( < 10, > 0): ");
                Scanner s = new Scanner(System.in);
                k = s.nextInt();
                if (k >= 10 || k <= 0) {
                    throw new Exception();
                }
                System.out.println("k = " + k);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        
        int[] a = new int[N];
        int[] b = new int[M];
        
        for (int i = 0; i < a.length / 2; i++) {
            a[i] = (int)(Math.random() * 100);
        }

        for (int i = 0; i < b.length; i++) {
            b[i] = (int)(Math.random() * 100);
        }

        System.out.println("Matrix A: ");
        for (int i = 0; i < a.length / 2; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();

        System.out.println("Matrix B: ");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "  ");
        }
        System.out.println();

        for(int i = k + 1, j = k + 1 + b.length; i < a.length / 2; i++, j++) {
            a[j] = a[i];
        }

        for(int i = k + 1, j = 0; j < b.length; i++, j++) {
            a[i] = b[j];
        }

        System.out.println("New matrix A: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();

    }
}