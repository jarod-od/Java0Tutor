package by.java_intro.basics_of_oop_5.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class TextFile extends File<String> {

    public TextFile(Directory dir, String name) {
        this.dir = dir;
        this.name = name;
    }

    @Override
    public void append(String data) {
        try {
            Path path = Paths.get(dir.getPath() + name);
            Files.write(path, data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        } catch(IOException e) {
            System.out.println("File " + name + " appending error!");
        }
    }

    @Override
    public void print() {
        try {
            Path path = Paths.get(dir.getPath() + name);
            List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);
            System.out.println("File " + name + " content:");
            for(String s : list) {
                System.out.println(s);
            }
        } catch(IOException e) {
            System.out.println("File " + name + " printing error!");
        }
    }
}