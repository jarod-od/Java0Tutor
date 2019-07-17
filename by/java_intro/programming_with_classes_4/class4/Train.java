package by.java_intro.programming_with_classes_4.class4;
/**
 *  4.  Создайте  класс  Train,  содержащий поля:  название  пункта  назначения, номер поезда,  
 * время  отправления.  Создайте  данные в массив из пяти элементов типа  Train, 
 * добавьте возможность сортировки элементов массива по  номерам поездов. 
 * Добавьте возможность вывода информации о поезде, номер которого введен пользователем.  
 * Добавьте  возможность  сортировки  массив  по  пункту  назначения,  причем  поезда  с  
 * одинаковыми  пунктами  назначения должны быть упорядочены по времени отправления. 
 */

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class Train {
    private String destinationName;
    private int trainNumber;
    private LocalTime arrivalTime;
    
    public Train(String destinationName, int trainNumber, LocalTime arrivalTime) {
        this.destinationName = new String(destinationName);
        this.trainNumber = trainNumber;
        this.arrivalTime = arrivalTime;
    }

    public void printTrainInfo() {
        System.out.println("Destination: " + destinationName + "; train number: " + trainNumber + "; arrival time: " + arrivalTime);
    }

    public static void printTrainsList(Train[] trains) {
        for (int i = 0; i < trains.length; i++) {
            trains[i].printTrainInfo();
        }
    }

    public static void sortByNumbers(Train[] trains) {
        Train[] sortedTrains = new Train[trains.length];
        System.out.println("Trains list sorted by numbers:");
        int[] trainsNumbers = new int[trains.length];
        for (int i = 0; i < trains.length; i++) {
            trainsNumbers[i] = trains[i].trainNumber;
        }
        Arrays.sort(trainsNumbers);
        for (int i = 0; i < trainsNumbers.length; i++) {
            for (int t = 0; t < trains.length; t++) {
                if (trainsNumbers[i] == trains[t].trainNumber) {
                    sortedTrains[i] = trains[t];
                }
            }
        }
        printTrainsList(sortedTrains);
    }

    @SuppressWarnings("resource")
    public static void getInfoByNumber(Train[] trains) {
        int number = 0;
        while (true) {
            try {
                System.out.println("Available numbers:");
                for (int i = 0; i < trains.length; i++) {
                    System.out.print(trains[i].trainNumber + " ");
                }
                System.out.println();
                System.out.println("Input number: ");
                Scanner s = new Scanner(System.in);
                number = s.nextInt();
                boolean isNumberRight = false;
                for (int i = 0; i < trains.length; i++) {
                    if (trains[i].trainNumber == number) {
                        isNumberRight = true;
                        trains[i].printTrainInfo();
                        return;
                    }
                }
                if (isNumberRight == true) {
                    return;
                } else {
                    System.out.println("Invalid input");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    public static void sortByDestinationAndArrivalTime(Train[] trains) {
        trains = getSortedArrayByArrivalTime(trains);
        Train[] sortedTrains = new Train[trains.length];
        System.out.println("Trains list sorted by destination:");
        String[] trainsDest = new String[trains.length];
        for (int i = 0; i < trains.length; i++) {
            trainsDest[i] = trains[i].destinationName;
        }
        Arrays.sort(trainsDest);
        /*
        String oldDest = null;
        int passCount = 0;
        for (int i = 0; i < trainsDest.length; i++) {
            if (oldDest != null) {
                if (oldDest.equals(trainsDest[i])) {
                    passCount++;
                } else {
                    passCount = 0;
                }
            }
            int tempPass = passCount;
            for (int t = 0; t < trains.length; t++) {
                if (trainsDest[i].equals(trains[t].destinationName)) {
                    if (tempPass == 0) {
                        sortedTrains[i] = trains[t];
                        break;
                    } else {
                        tempPass--;
                    }
                }
            }
            oldDest = trainsDest[i];
        }
        */
        for (int i = 0; i < trainsDest.length; i++) {
            for (int t = 0; t < trains.length; t++) {
                if (trainsDest[i] == trains[t].destinationName) {
                    sortedTrains[i] = trains[t];
                }
            }
        }
        printTrainsList(sortedTrains);
    }

    public static Train[] getSortedArrayByArrivalTime(Train[] trains) {
        Train[] sortedTrains = new Train[trains.length];
        LocalTime[] trainsArrivalTime = new LocalTime[trains.length];
        for (int i = 0; i < trains.length; i++) {
            trainsArrivalTime[i] = trains[i].arrivalTime;
        }
        Arrays.sort(trainsArrivalTime);
        for (int i = 0; i < trainsArrivalTime.length; i++) {
            for (int t = 0; t < trains.length; t++) {
                if (trainsArrivalTime[i] == trains[t].arrivalTime) {
                    sortedTrains[i] = trains[t];
                }
            }
        }
        return sortedTrains;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Train[] trains = createTrainsArray();
        
        while (true) {
            int command = 0;
            while (true) {
                try {
                    System.out.println("Commands:" + 
                    "\n 1 - sort by train numbers" +
                    "\n 2 - get info by number" + 
                    "\n 3 - sort by destination name and arrival time" +
                    "\n 0 - exit" +
                    "\n Input command number: ");
                    Scanner s = new Scanner(System.in);
                    command = s.nextInt();
                    if (command >= 0 && command <= 3) {
                        break;
                    } else {
                        System.out.println("Invalid input");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input");
                }
            }
            if (command == 0) {
                break;
            }

            switch(command) {
                case 1:
                    sortByNumbers(trains);
                    break;
                case 2:
                    getInfoByNumber(trains);
                    break;
                case 3:
                    sortByDestinationAndArrivalTime(trains);
                    break;
            }
        }
    }

    public static Train[] createTrainsArray() {
        Train[] trains = new Train[5];
        trains[0] = new Train("Paris", 1, LocalTime.parse("10:15"));
        trains[1] = new Train("Minsk", 13, LocalTime.parse("10:55"));
        trains[2] = new Train("Moscow", 234, LocalTime.parse("10:35"));
        trains[3] = new Train("Paris", 2, LocalTime.parse("10:45"));
        trains[4] = new Train("Minsk", 5, LocalTime.parse("10:45"));
        return trains;
    }
}