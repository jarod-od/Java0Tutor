package by.java_intro.strings_and_basics_of_text_processing_3.str3;
/**
 *  3. Проверить, является ли заданное слово палиндромом. 
 */
public class Main {

    public static void main(String[] args) {
        String s = "deified";
        System.out.println("Line: <" + s + ">");
        if (isPalindrome(s)) {
            System.out.println("Its palindrome!");
        } else {
            System.out.println("It isnt palindrome!");
        }
    }

    private static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        if (s.toLowerCase().equals(sb.toString().toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    
}