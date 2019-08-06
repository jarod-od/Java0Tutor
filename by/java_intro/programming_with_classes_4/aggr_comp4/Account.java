package by.java_intro.programming_with_classes_4.aggr_comp4;

public class Account {
    private int id;
    private Client client;
    private int amount;
    private boolean isBlocked = false;

    public Account(int id, Client client) {
        this(id, client, 0);
    }

    public Account(int id, Client client, int amount) {
        this.id = id;
        this.client = client;
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public int getAmount() {
        return amount;
    }

    public void block() {
        isBlocked = true;
    }

    public void unblock() {
        isBlocked = false;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    @Override
    public String toString() {
        return "\n{ " +
            "id = " + id + ", " +
            "client = " + client.toString() + ", " +
            "amount = " + amount + ", " +
            "is blocked = " + isBlocked +
            " }";
    }
}