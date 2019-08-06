package by.java_intro.programming_with_classes_4.aggr_comp4;

import java.util.Arrays;

/**
 *  4. Счета. Клиент может иметь несколько счетов в банке. 
 * Учитывать возможность блокировки/разблокировки счета. 
 * Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. 
 * Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */
public class BankTest {
    public static void main(String[] args) {
        Client c1 = new Client(1, "John");
        Client c2 = new Client(2, "Brut");
        Client c3 = new Client(3, "Yoda");

        Account a1 = new Account(1, c1, 10);
        Account a2 = new Account(2, c2, 100);
        Account a3 = new Account(3, c2, -50);
        Account a4 = new Account(4, c3, 30);

        Bank bank = new Bank(Arrays.asList(a1, a2, a3, a4));

        System.out.println("Accounts of client with id = 2 : " + bank.getAccountsByClientId(2).toString());

        System.out.println("Sum amount of client with id = 2 : " + bank.getAllAmountOfClient(2));

        System.out.println("Accounts sorted by clients ids : " + bank.sortAccountsByClientId().toString());

        System.out.println("Accounts sorted by clients names : " + bank.sortAccountsByClientName().toString());

        System.out.println("Accounts sorted by accounts amount : " + bank.sortAccountsByAccountAmount().toString());

        System.out.println("Sum all positive amount : " + bank.getAllPositiveAmount());

        System.out.println("Sum all negative amount : " + bank.getAllNegativeAmount());
    }
}