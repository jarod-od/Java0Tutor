package by.java_intro.strings_and_basics_of_text_processing_3.arr2;
/**
 *  2. Замените в строке все вхождения 'word' на 'letter'. 
 */
public class Main {

    public static void main(String[] args) {

        char[] line = "Cat table word world letter word".toCharArray();

        System.out.println("Line: " + new String(line));

        for (int i = 0; i < line.length; i++) {
            if (line[i] == 'w') {
                if (i + 1 < line.length && line[i + 1] == 'o') {
                    if (i + 2 < line.length && line[i + 2] == 'r') {
                        if (i + 3 < line.length && line[i + 3] == 'd') {
                            line = replace(line, i);
                        }
                    }
                }
            }
        }

        System.out.println("New line: " + new String(line));
    }

    public static char[] replace(char[] source, int index) {
        char[] t = new char[source.length + 2];
        for (int i = source.length - 1; i > index + 4; i--) {

        }

        for (int i = 0; i < index; i++) {
            t[i] = source[i];
        }
        char[] letter = "letter".toCharArray();
        for (int i = 0; i < letter.length; i++) {
            t[index + i] = letter[i];
        }
        for (int i = index + 4; i < source.length; i++) {
            t[i + 2] = source[i];
        }
        return t;
    }
}