package by.java_intro.strings_and_basics_of_text_processing_3.arr4;
/**
 *  4. В строке найти количество чисел. 
 */
public class Main {

    public static void main(String[] args) {

        char[] line = "a0sfd12 ghasdg3 hg4hghh5".toCharArray();

        System.out.println("Line: " + new String(line));

        int c = getNumeralsCount(line);

        System.out.println("Numerals count: " + c);
    }

    public static int getNumeralsCount(char[] source) {
        int c = 0;
        for (int i = 0; i < source.length; i++) {
            if (source[i] >= 48 && source[i] <= 57) {
                do {
                    i++;
                } while (i < source.length && source[i] >= 48 && source[i] <= 57);
                c++;
            }
        }
        return c;
    }
}