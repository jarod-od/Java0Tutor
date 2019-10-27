package by.java_intro.tasks_6.task4;

import by.java_intro.tasks_6.task4.model.Ship;

/**
 * Dock
 */
public class Dock extends Thread {

    private Ship ship;
    public int dockNumber;

    public Dock(int dockNumber) {
        this.dockNumber = dockNumber;
    }

    public void serveShip(Ship ship) {
        this.ship = ship;
    }

    @Override
    public void run() {
        System.out.println("dock # " + this.dockNumber + "; starts serve ship # " + ship.shipNumber + "; cont num = " + ship.getContainersCount() + "; size = " + ship.getCapacity());
        try {
            // ship unloading
            for (int i = 0; i < ship.getContainersCount(); i++) {
                ship.putContainer();
                PortTest.containersCount.getAndAdd(1);
                sleep(200);
            }

            // ship loading
            for (int i = 0; i < ship.getCapacity(); i++) {
                PortTest.containersCount.getAndAdd(-1);
                ship.pickUpContainer();
                sleep(200);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        PortTest.availableDocks.release();
        PortTest.isDockUsed[dockNumber].set(false);
        System.out.println("dock # " + this.dockNumber + "; ends serve ship # " + ship.shipNumber);
    }
}