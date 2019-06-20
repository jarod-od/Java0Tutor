package by.java_intro.strings_and_basics_of_text_processing_3.arr5;
/**
 *  5.  Удалить  в  строке все  лишние  пробелы,  
 * то  есть серии  подряд  идущих  пробелов  заменить на  одиночные пробелы.  
 * Крайние пробелы в строке удалить.   
 */
public class Main {

    public static void main(String[] args) {

        char[] line1 = "  a0sfd12  ghasdg3  hg4hghh5  ".toCharArray();
        char[] line2 = "a0sfd12 ghasdg3 hg4hghh5".toCharArray();

        System.out.println("Line1: <" + new String(line1) + ">");
        System.out.println("Line2: <" + new String(line2) + ">");

        line1 = removeSpaces(line1);
        line2 = removeSpaces(line2);

        System.out.println("New line1: <" + new String(line1) + ">");
        System.out.println("New line2: <" + new String(line2) + ">");
    }

    public static char[] removeSpaces(char[] source) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == ' ') {
                int s = 0;
                do {
                    i++;
                    s++;
                } while (i < source.length && source[i] == ' ');
                if (s > 1) {
                    source = remove(source, i - s, i - 1);
                    i = i - s + 1;
                }
            }
        }
        if (source[0] == ' ') {
            source = remove(source, 0, 1);
        }
        if (source[source.length - 1] == ' ') {
            source = remove(source, source.length - 1, source.length);
        }
        return source;
    }

    public static char[] remove(char[] source, int start, int end) {
        char[] t = new char[source.length - (end - start)];

        for (int i = 0; i < start; i++) {
            t[i] = source[i];
        }

        for (int i = end; i < source.length; i++) {
            t[i - (end - start)] = source[i];
        }
        return t;
    }
}