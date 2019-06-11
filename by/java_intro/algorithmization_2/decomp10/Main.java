package by.java_intro.algorithmization_2.decomp10;

/**
 *  10.  Дано  натуральное  число  N.  Написать  метод(методы)  для  формирования  массива,  
 * элементами  которого  являются цифры числа N. 
 */
public class Main {

    public static void main(String[] args) {
        long N = 243324553;
        int[] a = getArrayFromNumerals(N);

        System.out.println("Array from numerals of " + N);
        for(int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] getArrayFromNumerals(long n) {
        int size = (int)Math.log10(n) + 1;
        int[] a = new int[size];
        for (int i = a.length - 1; i >= 0 ; i--) {
            a[i] = (int)(n % 10);
            n = n / 10;
        }
        return a;
    }

        
}

