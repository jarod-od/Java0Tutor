package by.java_intro.programming_with_classes_4.aggr_comp2;

public class Engine {
    private int fuelConsumptionPerOneKm;
    public Engine(int fuelConsumptionPerOneKm) {
        this.fuelConsumptionPerOneKm = fuelConsumptionPerOneKm;
    }

    public int work() {
        return fuelConsumptionPerOneKm;
    }
}