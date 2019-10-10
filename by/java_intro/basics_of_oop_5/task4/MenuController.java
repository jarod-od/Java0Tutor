package by.java_intro.basics_of_oop_5.task4;

import java.util.Scanner;


/**
 * 4. Создать консольное приложение, удовлетворяющее следующим требованиям:   
 * • Приложение должно быть объектно-, а не процедурно-ориентированным.   
 * • Каждый класс должен иметь отражающее смысл название и информативный состав.   
 * • Наследование должно применяться только тогда, когда это имеет смысл.   
 * • При кодировании должны быть использованы соглашения об оформлении кода java code convention.   
 * • Классы должны быть грамотно разложены по пакетам.   
 * • Консольное меню должно быть минимальным.   
 * • Для хранения данных можно использовать файлы.    
 * 
 * Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере  дракона.  
 * Реализовать  возможность  просмотра  сокровищ,  выбора  самого  дорогого  по  стоимости  сокровища  и  
 * выбора сокровищ на заданную сумму.
 */

public class MenuController {

    final private static int TREASURE_COUNT = 100;
    private static boolean doRun = true;
    private static Cave cave;

    public static void main(String[] args) {
        cave = new Cave(TREASURE_COUNT);
        while (doRun) {
            int code = -1;

            printMainMenu();
            code = getCode();

            switch(code) {
                case 0: exitHandler(); break;
                case 1: viewTreasuresHandler(); break;
                case 2: getMostValuableTreasureHandler(); break;
                case 3: getTreasureBySumHandler(); break;
                default: wrongMainMenuInputHandler(); 
            }
        }
    }

    static private void printMainMenu() {
        System.out.println("------------------\nMenu:");
        System.out.println("1 - view treasures");
        System.out.println("2 - get most valuable treasure");
        System.out.println("3 - get treasures by sum");
        System.out.println("0 - exit");
    }

    @SuppressWarnings("resource")
    static private int getCode() {
        int code = -1;
        try {
            Scanner scanner = new Scanner(System.in);
            code = scanner.nextInt();
        } catch(Exception e) {
            wrongInputHandler();
        }
        return code;
    }

    static private void exitHandler() {
        doRun = false;
    }

    static private void viewTreasuresHandler() {
        if (cave != null) {
            cave.printCurrentTreasures();
        }
    }

    static private void getMostValuableTreasureHandler() {
        System.out.println(cave.getMostValuableTreasure());
    }

    @SuppressWarnings("resource")
    static private void getTreasureBySumHandler() {
        int value = -1;
        while (true) {
            System.out.println("Input value (> 0):");
            try {
                Scanner scanner = new Scanner(System.in);
                value = scanner.nextInt();
                if (value < 1) {
                    throw new Exception();
                }
                break;
            } catch(Exception e) {
                wrongInputHandler();
            }
        }

        cave.getTreasureBySum(value);
    }

    static private void wrongMainMenuInputHandler() {
        System.out.println("Wrong input, try harder!");
    }

    static private void wrongInputHandler() {
        System.out.println("Wrong input!");
    }
}