package by.java_intro.programming_with_classes_4.class7;
/**
 *  7.  Описать  класс, представляющий треугольник. 
 * Предусмотреть методы  для создания объектов,  вычисления  площади, периметра и точки пересечения медиан.
 */

public class Triangle {
    int[] x;
    int[] y;
    double a, b, c;

    public Triangle() {
        x = new int[3];
        y = new int[3];
        for (int i = 0; i < 3; i++) {
            x[i] = 0;
            y[i] = 0;
        }
        a = 0;
        b = 0;
        c = 0;
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        x = new int[3];
        y = new int[3];
        x[0] = x1;
        y[0] = y1;
        x[1] = x2;
        y[1] = y2;
        x[2] = x3;
        y[2] = y3;
        a = Math.sqrt( 
            Math.pow(Math.abs(x[0] - x[1]), 2) + 
            Math.pow(Math.abs(y[0] - y[1]), 2) 
            );
        b = Math.sqrt( 
            Math.pow(Math.abs(x[1] - x[2]), 2) + 
            Math.pow(Math.abs(y[1] - y[2]), 2) 
            );
        c = Math.sqrt( 
            Math.pow(Math.abs(x[2] - x[0]), 2) + 
            Math.pow(Math.abs(y[2] - y[0]), 2) 
            );
    }

    public double getArea() {
        double p = (a + b + c) / 2.;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public Point getMedianIntersectionPoint() {
        return new Point((x[0] + x[1] + x[2]) / 3., (y[0] + y[1] + y[2]) / 3.);
    }
}

class Point {
    public double x;
    public double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}