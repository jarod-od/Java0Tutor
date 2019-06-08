package by.java_intro.algorithmization_2.sort4;

/**

 *  4.  Сортировка  обменами.  Дана  последовательность  чисел  a1 <= a2 <= ... <= an .
 * Требуется  переставить  числа  в  порядке  возрастания.  
 * Для  этого  сравниваются  два  соседних  числа  a[i] и a[i+1].
 * Если  a[i] > a[i+1] ,  то  делается  перестановка. 
 * Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.  
 * Составить алгоритм сортировки, подсчитывая при этом количества перестановок. 
 */
public class Main {

    public static void main(String[] args) {

        final int N = 10;
        
        int[] a = new int[N];
        
        int shift = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 10) + shift;
            shift = a[i];
        }

        System.out.println("Seq A: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();

        System.out.println("Swap count: ");
        for (int j = a.length - 1; j > 0; j--) {
            int k = 0;
            for (int i = 0; i < j; i++) {
                //наверно в условии ошибка, поэтому "<", а не ">"
                if (a[i] < a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    k++;
                }
            }
            System.out.print(k + " ");
        }

        System.out.println("\nNew seq A: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();

    }
}