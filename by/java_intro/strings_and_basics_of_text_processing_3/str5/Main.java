package by.java_intro.strings_and_basics_of_text_processing_3.str5;
/**
 *  5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”. 
 */
public class Main {

    public static void main(String[] args) {
        String s = "fdas1 asdffd2  dfadsf3   asdfasdffdsa6      dsd1 ";
        System.out.println("Line: <" + s + ">");
        int c = getCountOfA(s);
        System.out.println("Count of \"a\": " + c);

    }

    private static int getCountOfA(String s) {
        int c = 0;
        int i = s.indexOf("a");
        while (i != -1) {
            c++;
            i = s.indexOf("a", i + 1);
        }
        return c;
    }

    
}