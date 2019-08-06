package by.java_intro.programming_with_classes_4.aggr_comp4;

public class Client {
    private int id;
    private String name;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{ " +
            "id = " + id + ", " +
            "name = " + name +
            " }";
    }
}