package by.java_intro.tasks_6.task1.model;

public enum BookType {
    EBOOK("E-book"),
    PAPER("Paper book");

    private String description;

    private BookType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}