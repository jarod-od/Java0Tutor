package by.java_intro.strings_and_basics_of_text_processing_3.str2;
/**
 *  2. В строке вставить после каждого символа 'a' символ 'b'. 
 */
public class Main {

    public static void main(String[] args) {
        String s = "fdas1 asdffd2  dfadsf3   asdfasdffdsa6      dsd1 ";
        System.out.println("Line: <" + s + ">");
        s = insert(s);
        System.out.println("New line: <" + s + ">");
    }

    private static String insert(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = sb.indexOf("a");
        while (i != -1) {
            sb.insert(i + 1, 'b');
            i = sb.indexOf("a", i + 1);
        }
        return sb.toString();
    }

    
}