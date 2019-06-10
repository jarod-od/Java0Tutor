package by.java_intro.algorithmization_2.decomp3;

/**
 *  3.  Вычислить  площадь  правильного  шестиугольника  со  стороной  а,  
 * используя  метод  вычисления  площади  треугольника. 
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Area of hexagon with side 5: " + getHexagonArea(5) + " (64.95)");
    }

    private static double getHexagonArea(double a) {
        return getTriangleArea(a) * 6;
    }

    private static double getTriangleArea(double a) {
        return Math.sqrt(3) / 4. * a * a;
    }
}