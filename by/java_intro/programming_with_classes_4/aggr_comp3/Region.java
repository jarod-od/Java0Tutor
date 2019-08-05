package by.java_intro.programming_with_classes_4.aggr_comp3;

public class Region {
    private String name;
    private int area;
    private City regionCenter;
    private City[] cities;

    public Region(String name, int area, City regionCenter, City[] cities) {
        this.name = name;
        this.area = area;
        this.regionCenter = regionCenter;
        this.cities = cities;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return area
     */
    public int getArea() {
        return area;
    }

    /**
     * @return center
     */
    public City getCenter() {
        return regionCenter;
    }
}