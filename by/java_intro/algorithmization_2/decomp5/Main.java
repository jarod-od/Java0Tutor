package by.java_intro.algorithmization_2.decomp5;

/**
 *  5. Составить программу, которая в массиве A[N] находит второе по величине число
 *  (вывести на печать число,  которое меньше максимального элемента массива, но больше всех других элементов). 
 */
public class Main {

    public static void main(String[] args) {
        final int N = 10;
        int[] a = new int[N];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 100);
        }

        System.out.println("Array A: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        int max = getMaxValue(a);

        int secondMax = getSecondMaxValue(a, max);

        System.out.println("Second max value: " + secondMax);

    }

    private static int getMaxValue(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static int getSecondMaxValue(int[] a, int m) {
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > max && i != m) {
                max = i;
            }
        }
        return max;
    }

    
}

