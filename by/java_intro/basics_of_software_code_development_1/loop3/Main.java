package by.java_intro.basics_of_software_code_development_1.loop3;

/**
 * 3. Найти сумму квадратов первых ста чисел. 
 */
public class Main {
    public static void main(String[] args) {
        long s = 0;
        for (long i = 0; i < 100; i++) {
            s += i * i;
        }
        System.out.println("Sum = " + s);
    }

}