package by.java_intro.programming_with_classes_4.class8;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 *  8. Создать класс  Customer, спецификация которого приведена ниже. 
 * Определить конструкторы,  set- и  get- методы  и метод  toString(). 
 * Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами  и методами. 
 * Задать критерии выбора данных и вывести эти данные на консоль.     
 * Класс  Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.    
 * Найти и вывести:   
 *  a) список покупателей в алфавитном порядке;    
 *  b) список покупателей, у которых номер кредитной карточки находится в заданном интервале 
 */

public class Main {
    private final int CUSTOMERS_LENGTH = 10;
    private Customer[] customers;

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Customers: ");
        main.printCustomers();
        main.printSortedCustomers();
        main.printCustomersInCardNumberRange(20, 60);
    }

    public Main() {
        customers = new Customer[CUSTOMERS_LENGTH];
        String[] subnames = {
            "Sidorov", "Petrov", "Ivanov", "Smith", "Kiselevich"
        };
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(i, subnames[(int)(Math.random() * 5)], "firstName" + i, "patronymic" + i, "address" + i,  (int)(Math.random() * 10 + i * 10), (int)(Math.random() * 100 + i * 100));
        }
    }

    public void printCustomers() {
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i].toString());
        }
    }

    private void printCustomers(Customer[] otherCustomers) {
        for (int i = 0; i < otherCustomers.length; i++) {
            System.out.println(otherCustomers[i].toString());
        }
    }

    public void printSortedCustomers() {
        Customer[] sortedCustomers = new Customer[customers.length];
        String[] fullNames = new String[customers.length];
        for (int i = 0; i < customers.length; i++) {
            fullNames[i] = customers[i].getSubName() + " " + customers[i].getFirstName() + " " + customers[i].getPatronymic();
        }
        Arrays.sort(fullNames);
        List<Integer> usedId = new ArrayList<>();
        for (int i = 0; i < fullNames.length; i++) {
            String[] fullName = fullNames[i].split(" ");
            for (int j = 0; j < customers.length; j++) {
                if (customers[j].getSubName().equals(fullName[0]) && customers[j].getFirstName().equals(fullName[1]) && customers[j].getPatronymic().equals(fullName[2]) && !usedId.contains(customers[j].getId())) {
                    usedId.add(customers[j].getId());
                    sortedCustomers[i] = customers[j];
                }
            }
        }
        System.out.println("Customers sorted by names: ");
        printCustomers(sortedCustomers);
    }

    public void printCustomersInCardNumberRange(int from, int to) {
        System.out.println("Customers with card number in range: " + from + " - " + to + " : ");
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getCardNumber() >= from && customers[i].getCardNumber() <= to) {
                System.out.println(customers[i].toString());
            }
        }
    }
}