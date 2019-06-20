package by.java_intro.strings_and_basics_of_text_processing_3.str7;
/**
 *  7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. 
 * Например, если было введено "abc cde  def", то должно быть выведено "abcdef". 
 */
public class Main {

    public static void main(String[] args) {
        //String s = "fdas1 asdffd2  dfadsf3   asdfasdffdsa6      dsd1 ";
        String s = "abc cde  def";
        System.out.println("Line: <" + s + ">");
        String ss = getUnique(s);
        System.out.println("Unique line: <" + ss + ">");
    }

    private static String getUnique(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c != ' ' && sb.indexOf(Character.toString(c)) == -1) {
                sb.append(Character.toString(c));
            }
        }
        return sb.toString();
    }

    
}