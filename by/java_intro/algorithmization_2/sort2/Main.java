package by.java_intro.algorithmization_2.sort2;

/**

 *  2. Даны две последовательности  a1 < a2 < .. < an и b1 < b2 < .. <bn . 
 * Образовать из них новую последовательность  чисел так, чтобы она тоже была неубывающей. 
 * Примечание.  Дополнительный массив не использовать.  
 */
public class Main {

    public static void main(String[] args) {

        final int N = 20, M = 10;
        
        int[] a = new int[N];
        int[] b = new int[M];
        
        int shift = 0;
        for (int i = 0; i < a.length / 2; i++) {
            a[i] = (int)(Math.random() * 10 + 1) + shift;
            shift = a[i];
        }

        shift = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] = (int)(Math.random() * 10 + 1) + shift;
            shift = b[i];
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

        int indexA = a.length / 2 - 1;
        int indexB = b.length - 1;
        int newIndex = a.length - 1;
        while(indexA != newIndex) {
            if(a[indexA] > b[indexB]) {
                a[newIndex--] = a[indexA--];
            } else {
                a[newIndex--] = b[indexB--];
            }
        }

        System.out.println("New matrix A: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();

    }
}