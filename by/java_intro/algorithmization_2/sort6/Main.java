package by.java_intro.algorithmization_2.sort6;

/**
 *  6.  Сортировка  Шелла.  Дан  массив  n  действительных  чисел.  
 * Требуется  упорядочить  его  по  возрастанию.  Делается это следующим образом: 
 * сравниваются два соседних элемента  a[i] и a[i+1] . Если  a[i] <= a[i+1] , 
 * то продвигаются  на  один  элемент вперед. Если  a[i] > a[i+1] , 
 * то производится перестановка и сдвигаются на один элемент назад.  
 * Составить алгоритм этой сортировки. 
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

        //чего-то в описании не хватает, добавил цикл и получилась пузырьковая сортировка 
        for (int j = 0; j < a.length; j++) {
            int i = a.length / 2;
            while (i < a.length - 1) {
                if (a[i] <= a[i + 1]) {
                    i++;
                } else {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    i--;
                }
            }
        }

        System.out.println("New seq A: ");
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + "  ");
        }
        System.out.println();
    }
}