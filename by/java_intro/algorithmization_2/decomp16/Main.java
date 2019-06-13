package by.java_intro.algorithmization_2.decomp16;

/**
 *  16.  Написать  программу,  определяющую  сумму  n  -  значных  чисел,  
 * содержащих  только  нечетные  цифры.  Определить также, 
 * сколько четных цифр в найденной сумме. 
 * Для решения задачи использовать декомпозицию. 
 */
public class Main {

    public static void main(String[] args) {
        int n = 3;

        int sum = findSumNumbersWithOddNumerals(n);
        System.out.println("Sum of numbers with odd numerals: " + sum);

        int k = findEvenNumeralsCount(sum);
        System.out.println("Count of even numerals in sum: " + k);
    }

    private static int findEvenNumeralsCount(int a) {
        int k = 0;
        while (a > 0) {
            int n = a % 10;
            if (n % 2 == 0) {
                k++;
            }
            a /= 10;
        }
        return k;
    }

    private static int findSumNumbersWithOddNumerals(int n) {
        int first = getMinNumber(n);
        int last = getMaxNumber(n);

        int sum = 0;
        for (int i = first; i < last; i++) {
            if (isNumberConsistOfOddNumerals(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean isNumberConsistOfOddNumerals(int a) {
        while(a > 0) {
            int n = a % 10;
            if (n % 2 == 0) {
                return false;
            }
            a /= 10;
        }
        return true;
    }

    private static int getMinNumber(int n) {
        int a = 1;
        for (int i = 1; i < n; i++) {
            a *= 10;
        }
        return a;
    }

    private static int getMaxNumber(int n) {
        int a = 1;
        for (int i = 0; i < n; i++) {
            a *= 10;
        }
        return a;
    }
    
}

