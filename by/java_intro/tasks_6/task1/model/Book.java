package by.java_intro.tasks_6.task1.model;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String[] authors;
    private String description;
    private BookType bookType;

    public Book(String title, String[] authors, String description, BookType bookType) {
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.bookType = bookType;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        String[] authorsCopy = new String[authors.length];
        for (int i = 0; i < authors.length; i++) {
            authorsCopy[i] = authors[i];
        }
        return authorsCopy;
    }

    public String getDescription() {
        return description;
    }

    public BookType getType() {
        return bookType;
    }

    @Override
    public String toString() {
        String str = "Title: " + title + "; Authors: ";
        for (int i = 0; i < authors.length; i++) {
            str += authors[i];
            if (i != authors.length - 1) {
                str += ", ";
            }
        }
        return str += "; Book type: " + bookType.getDescription() + ".";
    }
}