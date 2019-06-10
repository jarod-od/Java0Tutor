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
        int[] c = new int[M + N];
        
        int shift = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 10 + 1) + shift;
            shift = a[i];
        }

        shift = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] = (int)(Math.random() * 10 + 1) + shift;
            shift = b[i];
        }

        System.out.println("Seq A: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();

        System.out.println("Seq B: ");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "  ");
        }
        System.out.println();

        int indexA = 0;
        int indexB = 0;
        int newIndex = 0;
        while(newIndex < c.length) {
            if(indexB == b.length || a[indexA] < b[indexB]) {
                c[newIndex++] = a[indexA++];
            } else {
                c[newIndex++] = b[indexB++];
            }
        }

        System.out.println("Seq C: ");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + "  ");
        }
        System.out.println();

    }
}