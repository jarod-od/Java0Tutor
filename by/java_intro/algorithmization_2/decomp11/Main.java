package by.java_intro.algorithmization_2.decomp11;

/**
 *  11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр. 
 */
public class Main {

    public static void main(String[] args) {
        long a = 243324553L;
        long b = 5434553111L;

        System.out.println("Numbers: " + a + ", " + b);

        int result = compareNumerals(a, b);
        if (result == 1) {
            System.out.println("Number " + a + " has more numerals");
        } else if (result == -1) {
            System.out.println("Number " + b + " has more numerals");
        } else {
            System.out.println("Numbers have equal numerals count");
        }
    }

    private static int compareNumerals(long a, long b) {
        int al = (int)Math.log10(a);
        int bl = (int)Math.log10(b);
        if (al > bl) {
            return 1;
        } else if (bl > al) {
            return -1;
        } else {
            return 0;
        }
    }  
}

