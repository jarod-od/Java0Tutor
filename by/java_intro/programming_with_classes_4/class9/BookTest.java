package by.java_intro.programming_with_classes_4.class9;

/**
 *  9. Создать класс Book, спецификация которого приведена ниже. 
 * Определить конструкторы, set-и get-методы и метод  toString(). 
 * Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами. 
 * Задать критерии выбора данных и вывести эти данные на консоль. 
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета. 
 * Найти и вывести: 
 * a) список книг заданного автора; 
 * b) список книг, выпущенных заданным издательством; 
 * c) список книг, выпущенных после заданного года.
 */

public class BookTest {
    public static void main(String[] args) {
        Book[] books = initBooks();
        System.out.println("список всех книг: ");
        printBooks(books);

        System.out.println();
        System.out.println("список книг автора \"author25\": ");
        printBooks(getBooksByAuthor(books, "author25"));

        System.out.println();
        System.out.println("список книг, выпущенных издательством \"publishingHouse7\": ");
        printBooks(getBooksByPublishingHouse(books, "publishingHouse7"));

        System.out.println();
        System.out.println("список книг, выпущенных после " + 2007 + " года: ");
        printBooks(getBooksPublishedAfterYear(books, 2007));
    }

    public static Book[] initBooks() {
        Book[] books = new Book[10];
        for (int i = 0; i < 10; i++) {
            books[i] = new Book(i, "title" + i, new String[]{"author1" + i, "author2" + i}, "publishingHouse" + i, 2000 + i, 20 * i, 10 * i, "bindingType" + i);
        }
        return books;
    }

    public static Book[] getBooksByAuthor(Book[] books, String author) {
        Book[] newBooks = new Book[books.length];
        int k = 0;
        for (int i = 0; i < books.length; i++) {
            for (String bookAuthor : books[i].getAuthors()) {
                if (bookAuthor.equals(author)) {
                    newBooks[k] = books[i];
                    k++;
                    break;
                }
            }
        }
        Book[] resultBooks = new Book[k];
        for (int i = 0; i < k; i++) {
            resultBooks[i] = newBooks[i];
        }
        return resultBooks;
    }

    public static Book[] getBooksByPublishingHouse(Book[] books, String publishingHouse) {
        Book[] newBooks = new Book[books.length];
        int k = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getPublishingHouse().equals(publishingHouse)) {
                newBooks[k] = books[i];
                k++;
            }
        }
        Book[] resultBooks = new Book[k];
        for (int i = 0; i < k; i++) {
            resultBooks[i] = newBooks[i];
        }
        return resultBooks;
    }

    public static Book[] getBooksPublishedAfterYear(Book[] books, int publishingYear) {
        Book[] newBooks = new Book[books.length];
        int k = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getPublishingYear() > publishingYear) {
                newBooks[k] = books[i];
                k++;
            }
        }
        Book[] resultBooks = new Book[k];
        for (int i = 0; i < resultBooks.length; i++) {
            resultBooks[i] = newBooks[i];
        }
        return resultBooks;
    }

    public static void printBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }
    }
}

class Book {
    private int id;
    private String title;
    private String[] authors;
    private String publishingHouse;
    private int publishingYear;
    private int pageCount;
    private int price;
    private String bindingType; 

    public Book() {
    }

    public Book(int id, String title, String[] authors, String publishingHouse, int publishingYear, int pageCount, int price, String bindingType) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publishingHouse = publishingHouse;
        this.publishingYear = publishingYear;
        this.pageCount = pageCount;
        this.price = price;
        this.bindingType = bindingType;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return this.authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublishingHouse() {
        return this.publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getPublishingYear() {
        return this.publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBindingType() {
        return this.bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    @Override
    public String toString() {
        String result = "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", authors=[";
            for (int i = 0; i < authors.length; i++) {
                if (i != authors.length - 1) {
                    result += authors[i] + ", ";
                } else {
                    result += authors[i];
                }
            }
            result += "]" +
            ", publishingHouse='" + getPublishingHouse() + "'" +
            ", publishingYear='" + getPublishingYear() + "'" +
            ", pageCount='" + getPageCount() + "'" +
            ", price='" + getPrice() + "'" +
            ", bindingType='" + getBindingType() + "'" +
            "}";
        return result;
    }
}