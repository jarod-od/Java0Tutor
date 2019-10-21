package by.java_intro.tasks_6.task1.view;

import java.util.List;

import by.java_intro.tasks_6.task1.controller.MenuController;
import by.java_intro.tasks_6.task1.model.Book;
import by.java_intro.tasks_6.task1.model.BookType;

public class View {

    public static void runAdminMenu() {
        System.out.println("Admin menu. Choose action: ");
        System.out.println("1 - show all books");
        System.out.println("2 - add book");
        System.out.println("3 - delete book");
        System.out.println("4 - edit book");
        System.out.println("5 - show recommended books");
        System.out.println("0 - exit");
    }

    public static void runUserMenu() {
        System.out.println("Library. Choose action: ");
        System.out.println("1 - show all books");
        System.out.println("2 - search book");
        System.out.println("0 - exit");
    }

    public static void printBooks(List<Book> books) {
        if (books.size() <= 5) {
            System.out.println("Books: ");
            for (Book book : books) {
                System.out.println(book.toString());
            }
        } else {
            // page view
            int page = 1;
            boolean isViewing = true;
            while (isViewing) {
                System.out.println("Books (page " + page + "): ");
                for (int i = (page - 1) * 5; i < page * 5 && i < books.size(); i++) {
                    System.out.println("Id = " + i + "; " + books.get(i).toString());
                }
                System.out.println("1 - next page, 2 - previous page, 0 - stop");
                int code = MenuController.getCode(new int[] {0,1,2});
                switch (code) {
                    case 0:
                        isViewing = false;
                        break;
                    case 1:
                        if (books.size() % 5 == 0) {
                            if (page < books.size() / 5) {
                                page++;
                            }
                        } else {
                            if (page < books.size() / 5 + 1) {
                                page++;
                            }
                        }
                        break;
                    case 2:
                        if (page > 1) {
                            page--;
                        }
                        break;
                }
            }
        }
    }

    public static void showSearchMenu() {
        System.out.println("Find book by parameters: ");
    }

    public static void showAddMenu() {
        System.out.println("Input book parameters: ");
    }

    public static void chooseBookType() {
        System.out.println("Choose book type: ");
        BookType[] bookTypes = BookType.values();
        for (int i = 1; i < bookTypes.length + 1; i++) {
            System.out.println(i + " - " + bookTypes[i - 1].getDescription());
        }
        System.out.println("0 - any");
    }

    public static void chooseBookTypeStrict() {
        System.out.println("Choose book type: ");
        BookType[] bookTypes = BookType.values();
        for (int i = 1; i < bookTypes.length + 1; i++) {
            System.out.println(i + " - " + bookTypes[i - 1].getDescription());
        }
    }
}