package by.java_intro.strings_and_basics_of_text_processing_3.str4;
/**
 *  4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”. 
 */
public class Main {

    public static void main(String[] args) {
        String i = "информатика";
        System.out.println("Informatica: " + i);
        String t = getTort(i);
        System.out.println("Tort: " + t);
    }

    private static String getTort(String s) {
        String t = new String();
        t = t.concat(Character.toString(s.charAt(7)));
        t = t.concat(Character.toString(s.charAt(3)));
        t = t.concat(Character.toString(s.charAt(4)));
        t = t.concat(Character.toString(s.charAt(7)));
        return t;
    }

    
}