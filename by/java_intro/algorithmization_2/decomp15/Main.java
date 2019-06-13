package by.java_intro.algorithmization_2.decomp15;

/**
 *  15.  Найти  все  натуральные  n-значные  числа,  цифры  в  которых  образуют  строго  
 * возрастающую  последовательность (например, 1234, 5789). 
 * Для решения задачи использовать декомпозицию. 
 */
public class Main {

    public static void main(String[] args) {
        int n = 3;
        findNumbersWithIncreaseNumerals(n);
    }

    private static void findNumbersWithIncreaseNumerals(int n) {
        int first = getMinNumber(n);
        int last = getMaxNumber(n); 

        for(int i = first; i < last; i++) {
            if(isNumberWithIncreaseNumerals(i)) {
                System.out.println("Num with incr numerals: " + i);
            }
        }

    }

    private static boolean isNumberWithIncreaseNumerals(int a) {
        int old = -1;
        while (a > 0) {
            int n = a % 10;
            if (old != -1) {
                if (old <= n) {
                    return false;
                }
            }
            old = n;
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

