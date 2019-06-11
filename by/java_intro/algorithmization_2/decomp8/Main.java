package by.java_intro.algorithmization_2.decomp8;

/**
 *  8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] + D[5] + D[6].  
 * Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов  массива с номерами от k до m. 
 */
public class Main {

    public static void main(String[] args) {
        final int N = 7;
        int[] d = new int[N];

        for (int i = 0; i < d.length; i++) {
            d[i] = (int)(Math.random() * 100 + 1);
        }

        System.out.println("Array D: ");
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + " ");
        }
        System.out.println();

        System.out.println("D[l] + D[2] + D[3] = " + getSumOfThreeElementsInArray(d, 1));
        System.out.println("D[3] + D[4] + D[5] = " + getSumOfThreeElementsInArray(d, 3));
        System.out.println("D[4] + D[5] + D[6] = " + getSumOfThreeElementsInArray(d, 4));
    }

    private static int getSumOfThreeElementsInArray(int[] a, int k) {
        int sum = 0;
        for (int i = k; i < k + 3; i++) {
            sum += a[i];
        }
        return sum;
    }
    
}

