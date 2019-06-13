package by.java_intro.algorithmization_2.decomp13;

/**
 *  13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).  
 * Найти и напечатать все пары «близнецов» из отрезка [n,2n], где  n - заданное натуральное число больше 2. 
 * Для  решения задачи использовать декомпозицию. 
 */
public class Main {

    public static void main(String[] args) {
        int n = 100;

        findTwins(n);

    }

    private static void findTwins(int n) {
        int oldPrime = 0;
        for (int i = n; i <= n * 2; i++) {
            if (isNumberPrime(i)) {
                if (oldPrime != 0) {
                    if (i - oldPrime == 2) {
                        System.out.println("Twins: " + oldPrime + ", " + i);
                    }
                }
                oldPrime = i;
            }
        }
    }

    private static boolean isNumberPrime(int a) {
        if (a == 0 || a == 1) {
            return false;
        }
        if (a == 2 || a == 3) {
            return true;
        }
        for (int i = 2; i <= a / 2 + 1; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}

