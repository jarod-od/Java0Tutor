package by.java_intro.strings_and_basics_of_text_processing_3.str8;
/**
 *  8. Вводится строка слов, разделенных пробелами. 
 * Найти самое длинное слово и вывести его на экран. 
 * Случай, когда самых  длинных слов может быть несколько, не обрабатывать. 
 */
public class Main {

    public static void main(String[] args) {
        String s = "fdas1 asdffd2  dfadsf3   asdfasdffdsa6      dsd1 ";
        System.out.println("Line: <" + s + ">");
        String w = getLongestWord(s);
        System.out.println("Longest word: <" + w + ">");
    }

    private static String getLongestWord(String s) {
        int max = 0;
        int index = 0;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                k++;
            } else {
                if (k > max) {
                    max = k;
                    index = i - k;
                }
                k = 0;
            }
        }
        return s.substring(index, index + max);
    }

    
}