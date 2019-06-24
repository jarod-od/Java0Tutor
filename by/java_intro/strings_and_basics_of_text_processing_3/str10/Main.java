package by.java_intro.strings_and_basics_of_text_processing_3.str10;
/**
 *  10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой, 
 * восклицательным или вопросительным  знаком. Определить количество предложений в строке X. 
 */
public class Main {

    public static void main(String[] args) {
        String s = "Строка X состоит из нескольких предложений. Каждое из которых кончается точкой, восклицательным или вопросительным  знаком! Определить количество предложений в строке X?";
        System.out.println("Line: <" + s + ">");
        int c = getSentencesCount(s);
        System.out.println("Sentences count: " + c);
    }

    private static int getSentencesCount(String s) {
        int l = 0;
        for (char c : s.toCharArray()) {
            if (c == '!' || c == '?' || c == '.') {
                l++;
            }
        }
        return l;
    }
}