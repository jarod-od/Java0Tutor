package by.java_intro.algorithmization_2.decomp9;

/**
 *  9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. 
 * Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y — прямой. 
 */
public class Main {

    public static void main(String[] args) {
        double X = 5, Y = 5, Z = 10, T = 10;
        double s = getTetragonAreaBySides(X, Y, Z, T);
        System.out.println("Area of tetragon with sides " + X + " " + Y + " " + Z + " " + T + " = " + s);
    }

    // угол между сторонами длиной a и b — прямой
    private static double getTetragonAreaBySides(double a, double b, double c, double d) {
        double s = 0;
        double h = getHypotenuse(a, b);
        s = getRightTriangleArea(a, b) + getTriangeAreaBySides(c, d, h);
        return s;
    }

    private static double getTriangeAreaBySides(double a, double b, double c) {
        double p = (a + b + c) / 2.;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }

    private static double getHypotenuse(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    private static double getRightTriangleArea(double a, double b) {
        return a * b / 2.;
    }

    
}

