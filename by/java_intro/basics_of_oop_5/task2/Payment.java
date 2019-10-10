package by.java_intro.basics_of_oop_5.task2;

import java.util.List;
import java.util.ArrayList;

public class Payment {
    private class Product {
        public String name;
        public int price;
        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }
     
    private List<Product> products;

    public Payment() {
        products = new ArrayList<>();
    }

    public void addProduct(String name, int price) {
        products.add(new Product(name, price));
        System.out.println("Added product: " + name + ", price = " + price);
    }

    public int getAmount() {
        int amount = 0;
        for(Product product : products) {
            amount += product.price;
        }
        return amount;
    }
}