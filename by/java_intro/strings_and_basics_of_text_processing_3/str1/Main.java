package by.java_intro.strings_and_basics_of_text_processing_3.str1;
/**
 *  1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем. 
 */
public class Main {

    public static void main(String[] args) {
        String s = "fdas1 asdffd2  dfadsf3   asdfasdffdsa6      dsd1 ";
        System.out.println("Line: <" + s + ">");
        int c = getBiggestSpacesCount(s);
        System.out.println("Biggest spaces count: " + c);
    }

    private static int getBiggestSpacesCount(String s) {
        int c = 0;
        int index = 0;
        int i = s.indexOf(" ", index);
        while (i != -1) {
            int t = 0;
            while( i < s.length() && s.charAt(i) == ' ') {
                i++;
                t++;
            }
            if (t > c) {
                c = t;
            }
            index = i;
            i = s.indexOf(" ", index);
        }
        return c;
    }

    
}