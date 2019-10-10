package by.java_intro.basics_of_oop_5.task2;

/**
 * 2. Создать класс Payment с внутренним классом, 
 * с помощью объектов которого можно сформировать покупку из  нескольких товаров. 
 */

public class TestPayment {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.addProduct("phone", 1500);
        payment.addProduct("fish", 2);
        payment.addProduct("water", 1);
        System.out.println("Total amount of payment = " + payment.getAmount());
    }
}