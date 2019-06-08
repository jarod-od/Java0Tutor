package by.java_intro.algorithmization_2.sort5;

/**
 *  5. Сортировка вставками. Дана последовательность чисел  a1, a2, ... an . 
 * Требуется переставить числа в порядке  возрастания. Делается это следующим образом. 
 * Пусть  a1, a2, ... ai   - упорядоченная  последовательность, т. е. a1 <= a2 <= ... <= an .
 * Берется  следующее  число  a[i+1]   и  вставляется  в  последовательность  так,  
 * чтобы  новая  последовательность была тоже возрастающей. Процесс производится до тех пор, 
 * пока все элементы от i + 1 до n  не будут перебраны. 
 * Примечание. Место помещения очередного элемента в отсортированную часть производить  с помощью двоичного поиска. 
 * Двоичный поиск оформить в виде отдельной функции.  
 */
public class Main {

    public static void main(String[] args) {

        final int N = 10;
        
        int[] a = new int[N];
        
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 10);
        }

        System.out.println("Seq A: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();

        int index = 0;
        do {
            for (int i = index; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int newPos = findNewPos(a, index, a[i + 1]);
                    putInNewPos(a, index, i + 1, newPos);
                    index++;
                    break;
                }
                index++;
            }
        } while (index < a.length - 1);

        System.out.println("\nNew seq A: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();
    }

    private static int findNewPos(int[] a, int end, int num) {
        int p1 = 0;
        int p2 = end;
        int p = (int)Math.round(end / 2.);
        if (p2 == 0) {
            if (a[0] >= num) {
                return 0;
            } else {
                return 1;
            }
        }
        do {
            if (num == a[p]) {
                return p + 1;
            } else {
                if (num < a[p]) {
                    p2 = p;
                    p = (int)Math.round((p1 + p2) / 2.);
                } else {
                    p1 = p;
                    p = (int)Math.round((p1 + p2) / 2.);
                }
            }
        } while (p2 - p1 > 1);
        if (num < a[p1]) {
            return p1;
        } else {
            return p2;
        }
    }

    private static void putInNewPos(int[] a, int end, int numPos, int newPos) {
        int num = a[numPos];
        for (int i = end; i >= newPos; i--) {
            a[i + 1] = a[i];
        }
        a[newPos] = num;
    }
}