package by.java_intro.tasks_6.task2.view;

import java.util.List;

import by.java_intro.tasks_6.task2.model.Note;

public class View {
    public static void showMainMenu() {
        //todo
        System.out.println("Main menu. Choose action: ");
        System.out.println("1 - show all notes sorted");
        System.out.println("2 - add note");
        System.out.println("3 - search note");
        System.out.println("0 - exit");
    }

    public static void showAddNote() {
        System.out.println("To add note input title and data: ");
    }

    public static void showNotes(List<Note> notes) {
        for (int i = 0; i < notes.size(); i++) {
            System.out.println("Id = " + i + "; " + notes.get(i).toString());
        }
    }

    public static void showChooseSortParams() {
        System.out.println("Choose parameter for sort: ");
        System.out.println("1 - title");
        System.out.println("2 - data");
    }
    
}