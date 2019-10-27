package by.java_intro.tasks_6.task2.controller;

import by.java_intro.tasks_6.task2.view.View;
import by.java_intro.tasks_6.task2.util.Util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MenuController {

    private NoteController noteController;
    boolean runMenu = true;

    public MenuController() {
        noteController = new NoteController();
    }

    public void runMainMenu() {
         while(runMenu) {
            View.showMainMenu();
            int code = getCode(new int[]{0, 1, 2, 3});
            switch(code) {
                case 0: runExit(); break;
                case 1: showAllNotesSorted(); break;
                case 2: addNote(); break;
                case 3: findNote(); break;
            }
        }

    }

    private int getCode(int[] allowedCodes) {
        int code = -1;
        while(true) {
            if (allowedCodes != null) {
                System.out.println("Input code (allowed: " + Util.getStringFromIntArray(allowedCodes) + "):");
            } else {
                System.out.println("Input code:");
            }
            
            try {
                Scanner s = new Scanner(System.in);
                code = s.nextInt();
                if (allowedCodes != null) {
                    boolean isContains = false;
                    for (int a : allowedCodes) {
                        if (a == code) {
                            isContains = true;
                            break;
                        }
                    }
                    if (isContains) {
                        break;
                    }
                } else {
                    break;
                }
            } catch(Exception e) {
                //e.printStackTrace();
            }
            System.out.println("Invalid input");
        }
        return code;
    }

    private String getLine(String message) {
        String line = null;
        while(true) {
            System.out.println(message);
            try {
                Scanner s = new Scanner(System.in);
                line = s.nextLine();
                break;
            } catch(Exception e) {
                //e.printStackTrace();
            }
            System.out.println("Invalid input");
        }
        return line;
    }

    private void runExit() {
        noteController.saveNotes();
        runMenu = false;
    }

    private void showAllNotesSorted() {
        //todo
        View.showChooseSortParams();
        int code = getCode(new int[]{1, 2});
        switch(code) {
            case 1: noteController.showNotesSortedByTitle(); break;
            case 2: noteController.showNotesSortedByData(); break;
        }
    }

    private void addNote() {
        View.showAddNote();
        String theme = getLine("Input theme:");
        LocalDate date = null;
        while (true) {
            try {
                String dateStr = getLine("Input date:");
                date = LocalDate.parse(dateStr);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date!");
            }
        }
        
        String email = getLine("Input email:");
        String message = getLine("Input message:");
        noteController.addNote(theme, date, email, message);
    }

    private void findNote() {
        //todo
    }
}