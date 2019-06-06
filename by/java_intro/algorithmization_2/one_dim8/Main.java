package by.java_intro.algorithmization_2.one_dim8;

public class Main {
    static final int SEQ_SIZE = 10;
    public static void main(String[] args) {
        int[] A = new int[SEQ_SIZE];
        int min = Integer.MAX_VALUE;
        System.out.println("Array A: ");
        for (int i = 0; i < SEQ_SIZE; i++) {
            A[i] = (int)(Math.random() * 10);
            System.out.print(A[i] + " ");
            if (A[i] < min) {
                min = A[i];
            }
        }
        System.out.println();

        int[] B = new int[SEQ_SIZE];
        int bIndex = 0;
        for (int a: A) {
            if (a != min) {
                B[bIndex++] = a;
            }
        }

        System.out.println("New array : ");
        for (int i = 0; i < bIndex; i++) {
            System.out.print(B[i] + " ");
        }
    }
}