package by.java_intro.tasks_6.task4;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import by.java_intro.tasks_6.task4.model.Ship;

/**
 * Задание  4.  Многопоточность.  Порт  .  
 * Корабли  заходят  в  порт  для  разгрузки/загрузки контейнеров. 
 * Число контейнеров, находящихся в текущий момент  в  порту  и  на  корабле,  
 * должно  быть  неотрицательным  и  превышающим  заданную  грузоподъемность 
 * судна и вместимость порта. В порту работает несколько причалов.  
 * У одного причала может стоять один корабль. Корабль может загружаться у причала  или разгружаться. 
 */
public class PortTest {

    private static final int INIT_CONTAINERS_COUNT = 10000;
    private static final int DOCKS_COUNT = 5;
    private static final int SHIPS_COUNT = 10;

    public static final Semaphore availableDocks = new Semaphore(DOCKS_COUNT, true);
    public static AtomicInteger containersCount = new AtomicInteger(INIT_CONTAINERS_COUNT);
    public static AtomicBoolean[] isDockUsed;

    public static void main(String[] args) {
        
        isDockUsed = new AtomicBoolean[DOCKS_COUNT];

        for (int i = 0; i < DOCKS_COUNT; i++) {
            isDockUsed[i] = new AtomicBoolean(false);
        }

        List<Ship> shipsQueue = new LinkedList<>();

        for (int i = 0; i < SHIPS_COUNT; i++) {
            Ship ship = new Ship((int)(Math.random() * 10 + 1), 15, i);
            shipsQueue.add(ship);
        }

        while (shipsQueue.size() > 0) {
            //System.out.println("containersCount1 = " + containersCount.get());
            if (availableDocks.tryAcquire(1)) {
                Ship ship = shipsQueue.remove(0);
                for (int i = 0; i < DOCKS_COUNT; i++) {
                    if (!isDockUsed[i].get()) {
                        isDockUsed[i].set(true);
                        Dock dock = new Dock(i);
                        //System.out.println("ship # " + ship.shipNumber + " directed to dock # " + dock.dockNumber);
                        dock.serveShip(ship);
                        dock.start();
                        break;
                    }
                }
            }
            try {
                System.out.println("containersCount = " + containersCount.get());
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("containersCount end = " + containersCount.get());
    }
}