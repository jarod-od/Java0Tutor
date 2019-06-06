package by.java_intro.algorithmization_2.one_dim5;

public class Main {
    static final int SEQ_SIZE = 10;
    public static void main(String[] args) {
        double[] A = new double[SEQ_SIZE];
        System.out.println("Array A: ");
        for (int i = 0; i < SEQ_SIZE; i++) {
            A[i] = Math.random() * 10;
            System.out.print((int)(A[i] * 100)/100. + " ");
        }
        System.out.println();

        System.out.println("A[i] > i: ");
        for (int i = 0; i < SEQ_SIZE; i++) {
            if (A[i] > i) {
                System.out.print((int)(A[i] * 100)/100. + " ");
            }
        }
    }
}