package by.java_intro.tasks_6.task4.model;

/**
 * Ship
 */
public class Ship {
    private int containers;
    private int capacity;
    public int shipNumber;

    public Ship(int containers, int capacity, int shipNumber) {
        this.containers = containers;
        this.capacity = capacity;
        this.shipNumber = shipNumber;
    }

    public int getContainersCount() {
        return this.containers;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean pickUpContainer() {
        if (containers < capacity) {
            this.containers++;
            return true;
        } else {
            return false;
        }
    }

    public boolean putContainer() {
        if (containers > 0) {
            this.containers--;
            return true;
        } else {
            return false;
        }
    }

}