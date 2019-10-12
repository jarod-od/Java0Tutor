package by.java_intro.basics_of_oop_5.task5.gift;

public class Gift {
    private Sweets sweets;
    private GiftPackage giftPackage;

    public Gift() {
    }

    public void setSweets(Sweets sweets) {
        this.sweets = sweets;
    }

    public void setGiftPackage(GiftPackage giftPackage) {
        this.giftPackage = giftPackage;
    }

    @Override
    public String toString() {
        return "Gift info: " + sweets.toString() + "; " + giftPackage.toString();
    }
}