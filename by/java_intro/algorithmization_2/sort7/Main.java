package by.java_intro.algorithmization_2.sort7;

/**
 *  7.  Пусть даны две неубывающие последовательности действительных 
 * чисел  a1 < a2 < ... < an и b1 < b2 < ... <bm .  
 * Требуется указать те места, на которые нужно вставлять элементы 
 * последовательности b1 < b2 < ... <bm в первую  последовательность так, 
 * чтобы новая последовательность оставалась возрастающей.  
 */
public class Main {

    public static void main(String[] args) {

        final int N = 5, M = 5;
        
        int[] a = new int[N];
        int[] b = new int[M];
        
        int shift = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 10) + shift;
            shift = a[i];
        }

        shift = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] = (int)(Math.random() * 10) + shift;
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

        System.out.println("Places for B in A: ");
        int indexA = 0;
        for (int i = 0; i < b.length; i++) {
            while(indexA < a.length && a[indexA] < b[i]) {
                indexA++;
            }
            System.out.println(i + " " + b[i] + ", place: " + indexA);
        }
    }
}