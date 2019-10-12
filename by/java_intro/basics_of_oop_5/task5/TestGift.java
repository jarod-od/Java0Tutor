package by.java_intro.basics_of_oop_5.task5;

import by.java_intro.basics_of_oop_5.task5.gift.Gift;


/**
 * Задача 5.  Создать консольное приложение, удовлетворяющее следующим требованиям:   
 * •   Корректно спроектируйте и реализуйте предметную область задачи.   
 * •   Для создания объектов из иерархии классов продумайте возможность 
 * использования порождающих шаблонов  проектирования.  
 * •   Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.  
 * •   Для проверки корректности переданных данных можно применить регулярные выражения.  
 * •   Меню выбора действия пользователем можно не реализовывать, используйте заглушку.  
 * •   Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode(). 
 * 
 * Вариант B. Подарки. Реализовать приложение, позволяющее создавать подарки 
 * (объект, представляющий собой  подарок). Составляющими целого подарка являются сладости и упаковка. 
 */

public class TestGift {
    public static void main(String[] args) {

        int giftNumber = -1;

        GiftController giftController = new GiftController();

        int[] userInput = {5, 3};

        for (int input : userInput) {

            System.out.println("--------------------\nCreate gift:");
            System.out.println("1 - small");
            System.out.println("2 - meduim");
            System.out.println("3 - big");

            giftNumber = input;

            try {
                giftController.setGiftBuilderByNumber(giftNumber);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        giftController.createGift();
        Gift gift = giftController.getGift();


        System.out.println("Gift: [" + gift.toString() + "]");
    }
}