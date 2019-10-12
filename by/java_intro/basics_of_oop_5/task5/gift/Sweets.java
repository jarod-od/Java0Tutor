package by.java_intro.basics_of_oop_5.task5.gift;

public class Sweets {
    private String type;
    private int amount;

    public Sweets(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{Sweets type: " + type +", sweets amount: " + amount + "}";
    }
}