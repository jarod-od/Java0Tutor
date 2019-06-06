package by.java_intro.algorithmization_2.one_dim10;

public class Main {
    static final int SEQ_SIZE = 20;
    public static void main(String[] args) {
        int[] A = new int[SEQ_SIZE];

        System.out.println("Array A: ");
        for (int i = 0; i < SEQ_SIZE; i++) {
            A[i] = (int)(Math.random() * 10);
            System.out.print(A[i] + " ");
        }
        System.out.println();

        int newIndex = 1;
        for (int i = 2; i < SEQ_SIZE; i++) {
            if (i % 2 == 0) {
                A[newIndex++] = A[i];
            }
        }
        for (int i = newIndex; i < SEQ_SIZE; i++) {
            A[i] = 0;
        }

        System.out.println("New array A : ");
        for (int a : A) {
            System.out.print(a + " ");
        }

    }
}