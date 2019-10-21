package by.java_intro.tasks_6.task1.tools;

import by.java_intro.tasks_6.task1.model.Book;
import by.java_intro.tasks_6.task1.model.BookType;
import by.java_intro.tasks_6.task1.model.User;
import by.java_intro.tasks_6.task1.util.Util;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.List;

public class Tools {
    public static void main(String[] args) throws Exception {
        createUsers();
        createBooks();
    }

    public static void createUsers() throws Exception {
        //creating admin and users
        User admin = new User("admin", Util.getHash("1234"), true);
        User user = new User("user", Util.getHash("1111"), false);
        List<User> list = new ArrayList<>();
        list.add(admin);
        list.add(user);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("by\\java_intro\\tasks_6\\task1\\users.dat"));
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
    }

    public static void createBooks() throws Exception {
        //creating books
        //Book book1 = new Book("Book1", new String[] {"author1"}, "description1", BookType.PAPER);
        //Book book2 = new Book("Book2", new String[] {"author1", "author2"}, "description2", BookType.EBOOK);
        List<Book> list = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            list.add(new Book("Book" + i, new String[] {"author" + i}, "description" + i, BookType.values()[i % 2]) );
            list.add(new Book("Book0" + i, new String[] {"author" + i, "author" + (i + 1)}, "description0" + i, BookType.values()[i % 2]) );
        }
        
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("by\\java_intro\\tasks_6\\task1\\books.dat"));
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
    }
}