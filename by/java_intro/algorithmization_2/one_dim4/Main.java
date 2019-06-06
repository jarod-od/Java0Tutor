package by.java_intro.algorithmization_2.one_dim4;

public class Main {
    static final int SEQ_SIZE = 10;
    public static void main(String[] args) {
        double[] A = new double[SEQ_SIZE];
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE;
        int minIndex = 0, maxIndex = 0;
        System.out.println("Array A: ");
        for (int i = 0; i < SEQ_SIZE; i++) {
            A[i] = Math.random() * 100;
            System.out.print((int)(A[i] * 100)/100. + " ");
            if (A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
            if (A[i] < min) {
                min = A[i];
                minIndex = i;
            }
        }
        System.out.println();

        A[minIndex] = max;
        A[maxIndex] = min;

        System.out.println("New array A: ");
        for (double i : A) {
            System.out.print((int)(i * 100)/100. + " ");
        }
    }
}