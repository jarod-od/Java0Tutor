package by.java_intro.strings_and_basics_of_text_processing_3.arr3;
/**
 *  3. В строке найти количество цифр. 
 */
public class Main {

    public static void main(String[] args) {

        char[] line = "a0sfd12 ghasdg3 hg4hghh5".toCharArray();

        System.out.println("Line: " + new String(line));

        int c = getDigitsCount(line);

        System.out.println("Digits count: " + c);
    }

    public static int getDigitsCount(char[] source) {
        int c = 0;
        for (int i = 0; i < source.length; i++) {
            if (source[i] >= 48 && source[i] <= 57) {
                c++;
            }
        }
        return c;
    }
}