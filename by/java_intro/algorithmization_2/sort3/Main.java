package by.java_intro.algorithmization_2.sort3;

/**
 *  3. Сортировка выбором. Дана последовательность чисел  a1 <= a2 <= ... <= an .
 * Требуется переставить элементы так,  чтобы они были расположены по убыванию. 
 * Для этого в массиве, начиная с первого, выбирается наибольший  элемент и ставится на первое место, 
 * а первый - на место наибольшего. Затем, начиная со второго, эта процедура  повторяется. 
 * Написать алгоритм сортировки выбором. 
 */
public class Main {

    public static void main(String[] args) {

        final int N = 10;
        
        int[] a = new int[N];
        
        int shift = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 10) + shift;
            shift = a[i];
        }

        System.out.println("Seq A: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();

        int index = 0;
        do {
            int indexMax = 0;
            int max = Integer.MIN_VALUE;
            for (int i = index; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                    indexMax = i;
                }
            }

            int t = a[index];
            a[index] = a[indexMax];
            a[indexMax] = t;

            index++;
        } while (index < a.length);
        

        System.out.println("New seq A: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();

    }
}