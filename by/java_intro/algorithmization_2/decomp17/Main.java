package by.java_intro.algorithmization_2.decomp17;

// компилить с параметром -encoding utf8, а то ругается на описание
/**
 *  17. Из заданного числа вычли сумму его цифр. 
 * Из результата вновь вычли сумму его цифр и т.д. 
 * Сколько таких  действий надо произвести, чтобы получился нуль? 
 * Для решения задачи использовать декомпозицию. 
 */
public class Main {

    public static void main(String[] args) {
        int a = 1234;
        System.out.println("Number: " + a);

        int k = getActionCount(a);
        System.out.println("Actions count: " + k);
    }

    private static int getActionCount(int a) {
        int k = 0;
        while (a > 0) {
            a -= getNumeralsSum(a);
            k++;
        }
        return k;
    }

    private static int getNumeralsSum(int a) {
        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
    
}

