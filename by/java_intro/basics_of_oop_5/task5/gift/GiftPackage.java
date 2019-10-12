package by.java_intro.basics_of_oop_5.task5.gift;

public class GiftPackage {
    private String color;
    private String fabric;

    public GiftPackage(String color, String fabric) {
        this.color = color;
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "{Package color: " + color + ", package fabric: " + fabric + "}";
    }
}