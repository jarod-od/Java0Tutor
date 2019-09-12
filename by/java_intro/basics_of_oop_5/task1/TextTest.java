package by.java_intro.basics_of_oop_5.task1;

import java.io.IOException;

/**
 *  1. Создать объект класса Текстовый файл, используя классы Файл, Директория. 
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить. 
 */

public class TextTest {
    public static void main(String[] args) throws IOException {
        TextFile file = new TextFile(new Directory(".\\by\\java_intro\\basics_of_oop_5\\task1\\"), "test1.txt");
        file.create();
        file.append("data1");
        file.rename("test1_to_2.txt");
        file.print();
        file.delete();
    }
}