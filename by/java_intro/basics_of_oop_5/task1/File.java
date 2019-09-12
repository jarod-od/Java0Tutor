package by.java_intro.basics_of_oop_5.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.FileAlreadyExistsException;

public abstract class File<T extends Object> {
    Directory dir;
    String name;

    public void create() {
        try {
            Path path = Paths.get(dir.getPath() + name);
            Files.write(path, new byte[]{}, StandardOpenOption.CREATE_NEW);
        } catch(FileAlreadyExistsException e) {
            System.out.println("File " + name + " already exist!");
        } catch(IOException e) {
            System.out.println("File " + name + " creation error!");
        }
    }

    public void rename(String newName) {
        try {
            Path path = Paths.get(dir.getPath() + name);
            Files.move(path, path.resolveSibling(newName));
            name = newName;
        } catch(IOException e) {
            System.out.println("File " + name + " renaming error!");
        }
    }

    public abstract void print();

    public abstract void append(T data);

    public void delete() {
        try {
            Path path = Paths.get(dir.getPath() + name);
            Files.delete(path);
        } catch(IOException e) {
            System.out.println("File " + name + " deleting error!");
        }
    }
}