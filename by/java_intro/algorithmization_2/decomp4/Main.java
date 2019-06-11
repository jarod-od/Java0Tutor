package by.java_intro.algorithmization_2.decomp4;

/**
 *  4. На плоскости заданы своими координатами  n точек. 
 * Написать метод(методы), определяющие, между какими  из пар точек самое большое расстояние. 
 * Указание. Координаты точек занести в массив. 
 */
public class Main {

    public static void main(String[] args) {
        final int N = 10;
        double[] x = new double[N];
        double[] y = new double[N];

        for (int i = 0; i < x.length; i++) {
            x[i] = (int)(Math.random() * 10000) / 100.;
        }

        for (int i = 0; i < y.length; i++) {
            y[i] = (int)(Math.random() * 10000) / 100.;
        }

        System.out.println("Points: ");
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i] + ", " + y[i]);
        }

        int[] indexes = getMaxDistanceIndex(x, y);

        System.out.println("Max distance between : " + x[indexes[0]] + ", " + y[indexes[0]] + " and " + x[indexes[1]] + ", " + y[indexes[1]]);

    }

    private static int[] getMaxDistanceIndex(double[] x, double[] y) {
        double max = Double.MIN_VALUE;
        int maxIndex1 = 0, maxIndex2 = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = i; j < x.length; j++) {
                double d = getDistance(x[i], y[i], x[j], y[j]);
                if (d > max) {
                    max = d;
                    maxIndex1 = i;
                    maxIndex2 = j;
                }
            }
        }
        return new int[] {maxIndex1, maxIndex2};
    }

    private static double getDistance(double x1, double y1, double x2, double y2) {
        double x = Math.abs(x1 - x2);
        double y = Math.abs(y1 - y2);
        return Math.sqrt(x * x + y * y);
    }
}

