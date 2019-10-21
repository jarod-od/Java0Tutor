package by.java_intro.tasks_6.task1.controller;

import by.java_intro.tasks_6.task1.model.Book;
import by.java_intro.tasks_6.task1.model.BookType;
import by.java_intro.tasks_6.task1.util.Util;
import by.java_intro.tasks_6.task1.view.View;

import java.util.List;
import java.util.NoSuchElementException;

import java.util.Scanner;

public class MenuController {

    private boolean runMenu = true;
    private BookController bookController;

    public MenuController() {
        bookController = new BookController();
    }

    //todo
    public void runAdminMenu() {
        while(runMenu) {
            View.runAdminMenu();
            int code = getCode(new int[]{0, 1, 2, 3, 4});
            switch(code) {
                case 0: runExit(); break;
                case 1: showAllBooks(); break;
                case 2: addBook(); break;
                case 3: removeBook(); break;
                case 4: editBook(); break;
                case 5: showRecommendedBooks(); break;
            }
        }
    }

    public void runUserMenu() {
        while(runMenu) {
            View.runUserMenu();
            int code = getCode(new int[]{0, 1, 2, 3});
            switch(code) {
                case 0: runExit(); break;
                case 1: showAllBooks(); break;
                case 2: searchBook(); break;
                case 3: recommendBook(); break;
            }
        }
        
    }

    public static int getCode(int[] allowedCodes) {
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
                boolean isContains = false;
                if (allowedCodes != null) {
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
                
            } catch(NoSuchElementException | IllegalStateException e) {
                //e.printStackTrace();
            }
            System.out.println("Invalid input");
        }
        return code;
    }

    private void runExit() {
        runMenu = false;
        System.out.println("Goodbye!");
    }

    private void showAllBooks() {
        bookController.printAllBooks();
    }

    private void searchBook() {
        View.showSearchMenu();

        //get title
        String title = getLine("Input book title (or press \"Enter\"): ");
        if (title.equals("")) {
            title = null;
        }

        //get authors
        String authorsLine = getLine("Input book authors (split by \';\') (or press \"Enter\"): ");
        String[] authors = null;
        if (!authorsLine.equals("")) {
            authors = authorsLine.split(";");
            for (int i = 0; i < authors.length; i++) {
                authors[i] = authors[i].trim();
            }
        }

        //choose type
        View.chooseBookType();
        int[] allowedCodes = new int[BookType.values().length + 1];
        for (int i = 0; i < allowedCodes.length; i++) {
            allowedCodes[i] = i;
        }
        int code = getCode(allowedCodes);
        BookType bookType = null;
        if(code != 0) {
            bookType = BookType.values()[code - 1];
        }
        
        List<Book> foundBooks = bookController.findBooks(title, authors, bookType);
        if (foundBooks.size() > 0) {
            System.out.println("Search result:");
            View.printBooks(foundBooks);
        } else {
            System.out.println("No book found");
        }
        
    }

    private String getLine(String message) {
        String line = null;
        while(true) {
            System.out.println(message);
            try {
                Scanner s = new Scanner(System.in);
                line = s.nextLine();
                break;
            } catch(NoSuchElementException | IllegalStateException e) {
                //e.printStackTrace();
            }
            System.out.println("Invalid input");
        }
        return line;
    }

    private void addBook() {
        //todo
        View.showAddMenu();

        //get title
        String title = null;
        while (true) {
            title = getLine("Input book title: ");
            if (!title.equals("")) {
                break;
            } else {
                System.out.println("Book must has title");
            }
        }
        
        //get authors
        String[] authors = null;
        while (true) {
            String authorsLine = getLine("Input book authors (split by \';\') (or press \"Enter\"): ");
            if (!authorsLine.equals("")) {
                authors = authorsLine.split(";");
                for (int i = 0; i < authors.length; i++) {
                    authors[i] = authors[i].trim();
                }
                break;
            } else {
                System.out.println("Book must has author");
            }
        }
        
        //choose type
        View.chooseBookTypeStrict();
        int[] allowedCodes = new int[BookType.values().length];
        for (int i = 0; i < allowedCodes.length; i++) {
            allowedCodes[i] = i + 1;
        }
        int code = getCode(allowedCodes);
        BookType bookType = null;
        bookType = BookType.values()[code - 1];

        //get description
        String description = null;
        while (true) {
            title = getLine("Input book description: ");
            if (!title.equals("")) {
                break;
            } else {
                System.out.println("Book must has description");
            }
        }
        
        if (bookController.addBook(title, authors, description, bookType) == 1) {
            System.out.println("Book added");
        } else {
            System.out.println("Error. Book didn't add");
        }
    }

    private void removeBook() {
        //todo
        bookController.printAllBooks();
        System.out.println("Input book id");
        if (bookController.removeBook(getCode(null)) == 1) {
            System.out.println("Book removed");
        } else {
            System.out.println("Error. Book didn't remove");
        }
    }

    private void editBook() {
        //todo
    }

    private void showRecommendedBooks() {
        //todo
    }

    private void recommendBook() {
        //todo
    }
}