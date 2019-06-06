package by.java_intro.algorithmization_2.one_dim7;

public class Main {
    static final int SEQ_SIZE = 20;
    public static void main(String[] args) {
        double[] A = new double[SEQ_SIZE];
        System.out.println("Array A: ");
        for (int i = 0; i < SEQ_SIZE; i++) {
            A[i] = Math.random() * 10;
            System.out.print((int)(A[i] * 100)/100. + " ");
        }
        System.out.println();

        double max = Double.MIN_VALUE;
        for (int i = 0; i < SEQ_SIZE / 2; i++) {
            if (A[i] + A[SEQ_SIZE - i - 1] > max) {
                max = A[i] + A[SEQ_SIZE - i - 1];
            }
        }
        System.out.println("Max : " + (int)(max * 100)/100.);
    }
}