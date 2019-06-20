package by.java_intro.strings_and_basics_of_text_processing_3.str9;
/**
 *  9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. 
 * Учитывать только английские  буквы.  
 */
public class Main {

    public static void main(String[] args) {
        String s = "fDas1 asdFfd2  dfaDsf3   aSdfAsdFfdsA6      dsD1 ";
        System.out.println("Line: <" + s + ">");
        int low = getLowCaseCount(s);
        int up = getUpperCaseCount(s);
        System.out.println("Low case count: " + low + ", upper case count: " + up);
    }

    private static int getLowCaseCount(String s) {
        int l = 0;
        for (char c : s.toCharArray()) {
            if (c >= 97 && c <= 122) {
                l++;
            }
        }
        return l;
    }

    private static int getUpperCaseCount(String s) {
        int u = 0;
        for (char c : s.toCharArray()) {
            if (c >= 65 && c <= 90) {
                u++;
            }
        }
        return u;
    }
}