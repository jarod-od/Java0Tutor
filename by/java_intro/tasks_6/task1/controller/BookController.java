package by.java_intro.tasks_6.task1.controller;

import by.java_intro.tasks_6.task1.model.Book;
import by.java_intro.tasks_6.task1.model.BookType;
import by.java_intro.tasks_6.task1.view.View;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    List<Book> books;

    public BookController() {
        readBookList();
    }

    private void readBookList() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("by\\java_intro\\tasks_6\\task1\\books.dat"))) {
            List objList = (List) objectInputStream.readObject();
            books = new ArrayList<>();
            for(Object obj : objList) {
                books.add((Book) obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printAllBooks() {
        View.printBooks(books);
    }

    public List<Book> findBooks(String title, String[] authors, BookType bookType) {
        List<Book> foundBooks = new ArrayList<>();
        
        for (Book book : books) {
            boolean isTitleFit = false, isAuthorsFit = false, isTypeFit = false;

            //title
            if (title != null) {
                if(title.equals(book.getTitle())) {
                    isTitleFit = true;
                }
            } else {
                isTitleFit = true;
            }

            //authors
            if (authors != null) {
                boolean isFitAll = true;
                for(String author : authors) {
                    boolean isFitCurrent = false;
                    for (String bookAuthor : book.getAuthors()) {
                        if (author.equals(bookAuthor)) {
                            isFitCurrent = true;
                            break;
                        }
                    }
                    if (!isFitCurrent) {
                        isFitAll = false;
                    }
                }
                if (isFitAll) {
                    isAuthorsFit = true;
                } else {
                    isAuthorsFit = false;
                }
            } else {
                isAuthorsFit = true;
            }

            //book type
            if (bookType != null) {
                if(bookType.equals(book.getType())) {
                    isTypeFit = true;
                }
            } else {
                isTypeFit = true;
            }

            if (isTitleFit && isAuthorsFit && isTypeFit) {
                foundBooks.add(book);
            }
        }

        return foundBooks;
    }

    public int addBook(String title, String[] authors, String description, BookType bookType) {
        try {
            books.add(new Book(title, authors, description, bookType));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("by\\java_intro\\tasks_6\\task1\\books.dat"));
            objectOutputStream.writeObject(books);
            objectOutputStream.close();
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    public int removeBook(int id) {
        try {
            books.remove(id);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("by\\java_intro\\tasks_6\\task1\\books.dat"));
            objectOutputStream.writeObject(books);
            objectOutputStream.close();
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

}