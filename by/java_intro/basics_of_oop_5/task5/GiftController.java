package by.java_intro.basics_of_oop_5.task5;

import by.java_intro.basics_of_oop_5.task5.gift_builder.GiftBuilder;
import by.java_intro.basics_of_oop_5.task5.gift.Gift;
import by.java_intro.basics_of_oop_5.task5.gift_builder.SmallGiftBuilder;
import by.java_intro.basics_of_oop_5.task5.gift_builder.MediumGiftBuilder;
import by.java_intro.basics_of_oop_5.task5.gift_builder.BigGiftBuilder;

public class GiftController {
    private GiftBuilder giftBuilder;

    public void setGiftBuilderByNumber(int number) throws Exception {
        switch (number) {
            case 1: this.giftBuilder = new SmallGiftBuilder(); break;
            case 2: this.giftBuilder = new MediumGiftBuilder(); break;
            case 3: this.giftBuilder = new BigGiftBuilder(); break;
            default: throw new Exception("Wrong input!");
        }
    }

    public void createGift() {
        giftBuilder.createGift();
        giftBuilder.buildSweets();
        giftBuilder.buildPackage();
    }

    public Gift getGift() {
        return giftBuilder.getGift();
    }
}