package by.java_intro.basics_of_software_code_development_1.loop6;

/**
 * 6. Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера. 
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 33; i < 127; i++) {
            System.out.println("Code = " + i + ", symbol = " + (char)i);
        }
    }

}