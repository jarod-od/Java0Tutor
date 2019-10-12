package by.java_intro.basics_of_oop_5.task5.gift_builder;

import by.java_intro.basics_of_oop_5.task5.gift.Sweets;
import by.java_intro.basics_of_oop_5.task5.gift.GiftPackage;

public class BigGiftBuilder extends GiftBuilder {
    public void buildSweets() {
        gift.setSweets(new Sweets("chocolate", 30));
    }
    public void buildPackage() {
        gift.setGiftPackage(new GiftPackage("red", "textile"));
    }
}