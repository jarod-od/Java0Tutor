package by.java_intro.strings_and_basics_of_text_processing_3.str6;
/**
 *  6. Из заданной строки получить новую, повторив каждый символ дважды. 
 */
public class Main {

    public static void main(String[] args) {
        String s = "fdas1 asdffd2  dfadsf3   asdfasdffdsa6      dsd1 ";
        System.out.println("Line: <" + s + ">");
        String ss = repeat(s);
        System.out.println("New line: <" + ss + ">");
    }

    private static String repeat(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append(c);
        }
        return sb.toString();
    }

    
}