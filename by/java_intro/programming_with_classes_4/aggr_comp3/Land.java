package by.java_intro.programming_with_classes_4.aggr_comp3;

public class Land {
    private String name;
    private Region[] regions;
    private City capital;
    public Land(String name, City capital, Region[] regions) {
        this.name = name;
        this.capital = capital;
        this.regions = regions;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the capital
     */
    public City getCapital() {
        return capital;
    }

    /**
     * @return regions count
     */
    public int getRegionsCount() {
        return regions.length;
    }

    /**
     * @return area
     */
    public int getArea() {
        int area = 0;
        for(Region region : regions) {
            area += region.getArea();
        }
        return area;
    }

    /**
     * @return regions centers
     */
    public String getRegionsCenters() {
        StringBuilder centers = new StringBuilder("{ ");
        for(int i = 0; i < regions.length; i++) {
            if (i < regions.length - 1) {
                centers.append(regions[i].getCenter().getName() + ", ");
            } else {
                centers.append(regions[i].getCenter().getName() + " }");
            }
        }
        return centers.toString();
    }
}