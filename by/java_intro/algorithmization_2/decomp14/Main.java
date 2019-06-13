package by.java_intro.algorithmization_2.decomp14;

/**
 *  14.  Натуральное  число,  в  записи  которого  n  цифр,  называется  числом  Армстронга,  
 * если  сумма  его  цифр,  возведенная в степень  n, равна  самому  числу. 
 * Найти  все  числа Армстронга  от  1 до  k.  
 * Для решения  задачи  использовать декомпозицию. 
 */
public class Main {

    // в условии опечатка, будем возводить в степень цифры, а не их сумму
    public static void main(String[] args) {
        int k = 10000;

        findArmstrongNumbers(k);
    }

    private static int getNumeralsCount(int a) {
        return (int)Math.log10(a) + 1;
    }

    private static void findArmstrongNumbers(int k) {
        for (int i = 1; i <= k; i++) {
            if(isNumberOccurArmstrong(i)) {
                System.out.println("Armstrong number: " + i);
            }
        }
    }

    private static boolean isNumberOccurArmstrong(int a) {
        int n = getNumeralsCount(a);
        int sum = 0;
        int backup = a;
        while (a > 0) {
            sum += Math.pow(a % 10, n);
            a /= 10;
        }
        if (sum == backup) {
            return true;
        } else {
            return false;
        }
    }
    
}

