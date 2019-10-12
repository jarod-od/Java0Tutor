package by.java_intro.basics_of_oop_5.task5.gift_builder;

import by.java_intro.basics_of_oop_5.task5.gift.Gift;

public abstract class GiftBuilder {
    Gift gift;

    public Gift getGift() {
        return gift;
    }

    public void createGift() {
        gift = new Gift();
    }

    public abstract void buildSweets();
    public abstract void buildPackage();
}