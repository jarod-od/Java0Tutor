package by.java_intro.programming_with_classes_4.aggr_comp3;

/**
 *  3.Создать объект класса Государство, используя классы Область, Район, Город. 
 * Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 */

public class LandTest {
    public static void main(String[] args) {
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");

        Region r1 = new Region("reg 1", 12, a, new City[]{a, b});
        Region r2 = new Region("reg 2", 3, c, new City[]{c});
        Region r3 = new Region("reg 3", 59, f, new City[]{d, e, f});

        Land land = new Land("Great Land", f, new Region[]{r1, r2, r3});

        System.out.println("Land created, name : " + land.getName());
        System.out.println("Land capital: " + land.getCapital().getName());
        System.out.println("Land region count: " + land.getRegionsCount());
        System.out.println("Land area: " + land.getArea());
        System.out.println("Land regions centers: " + land.getRegionsCenters());
        
    }
}