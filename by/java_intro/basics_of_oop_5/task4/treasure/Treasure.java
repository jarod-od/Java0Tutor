package by.java_intro.basics_of_oop_5.task4.treasure;

public class Treasure {
    private TreasureType treasureType;
    private int amount;
    public Treasure(TreasureType treasureType, int amount) {
        this.treasureType = treasureType;
        this.amount = amount;
    }

    public Treasure(Treasure treasure, int newAmount) {
        this.treasureType = treasure.treasureType;
        this.amount = newAmount;
    }

    @Override
    public String toString() {
        return "Title: " + treasureType.getTitle() + ", price: " + treasureType.getPrice() + ", amount: " + amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int newAmount) {
        this.amount = newAmount;
    }

    public int getPrice() {
        return treasureType.getPrice();
    }

    public String getTitle() {
        return treasureType.getTitle();
    }
}