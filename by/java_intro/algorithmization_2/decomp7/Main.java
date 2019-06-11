package by.java_intro.algorithmization_2.decomp7;

/**
 *  7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9. 
 */
public class Main {

    public static void main(String[] args) {
        long sum = getSumFactOdd(1, 9);
        System.out.println("Sum of factorials of odd numbers from 1 to 9 : " + sum);
    }

    private static long getSumFactOdd(int first, int last) {
        long sum = 0;
        if (first % 2 == 0) {
            first++;
        }
        if (last % 2 == 0) {
            last--;
        }
        for (int i = first; i <= last; i += 2) {
            sum += getFact(i);
        }
        return sum;
    }

    private static long getFact(int a) {
        long f = 1;
        for (int i = 1; i <= a; i++) {
            f *= i;
        }
        return f;
    } 
    
}

