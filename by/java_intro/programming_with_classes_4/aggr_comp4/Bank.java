package by.java_intro.programming_with_classes_4.aggr_comp4;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Bank {
    List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public Bank(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Bank(Account account) {
        this.accounts = new ArrayList<>();
        this.accounts.add(account);
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> getAccountsByClientId(int clientId) {
        List<Account> clentsAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getClient().getId() == clientId) {
                clentsAccounts.add(account);
            }
        }
        return clentsAccounts;
    }

    public List<Account> sortAccountsByClientId() {
        List<Account> sorted = new ArrayList<>();
        List<Integer> clientIds = new ArrayList<>();

        for (Account account : accounts) {
            clientIds.add(account.getClient().getId());
        }

        Collections.sort(clientIds);
        boolean[] isUsed = new boolean[accounts.size()];
        for (boolean flag : isUsed) {
            flag = false;
        }

        for (Integer id : clientIds) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getClient().getId() == id && !isUsed[i]) {
                    sorted.add(accounts.get(i));
                    isUsed[i] = true;
                }
            }
        }
        return sorted;
    }

    public List<Account> sortAccountsByClientName() {
        List<Account> sorted = new ArrayList<>();
        List<String> clientNames = new ArrayList<>();

        for (Account account : accounts) {
            clientNames.add(account.getClient().getName());
        }

        Collections.sort(clientNames);
        boolean[] isUsed = new boolean[accounts.size()];
        for (boolean flag : isUsed) {
            flag = false;
        }

        for (String name : clientNames) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getClient().getName().equals(name) && !isUsed[i]) {
                    sorted.add(accounts.get(i));
                    isUsed[i] = true;
                }
            }
        }
        return sorted;
    }

    public List<Account> sortAccountsByAccountAmount() {
        List<Account> sorted = new ArrayList<>();
        List<Integer> amounts = new ArrayList<>();

        for (Account account : accounts) {
            amounts.add(account.getAmount());
        }

        Collections.sort(amounts);
        boolean[] isUsed = new boolean[accounts.size()];
        for (boolean flag : isUsed) {
            flag = false;
        }

        for (Integer amount : amounts) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getAmount() == amount && !isUsed[i]) {
                    sorted.add(accounts.get(i));
                    isUsed[i] = true;
                }
            }
        }
        return sorted;
    }

    public int getAllAmountOfClient(int clientId) {
        int sum = 0;
        for (Account account : accounts) {
            if (account.getClient().getId() == clientId && !account.isBlocked()) {
                sum += account.getAmount();
            }
        }
        return sum;
    }

    public int getAllPositiveAmount() {
        int sum = 0;
        for (Account account : accounts) {
            if (account.getAmount() > 0) {
                sum += account.getAmount();
            }
        }
        return sum;
    }

    public int getAllNegativeAmount() {
        int sum = 0;
        for (Account account : accounts) {
            if (account.getAmount() < 0) {
                sum += account.getAmount();
            }
        }
        return sum;
    }
}