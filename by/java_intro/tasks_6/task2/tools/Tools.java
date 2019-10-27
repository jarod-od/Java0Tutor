package by.java_intro.tasks_6.task2.tools;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.java_intro.tasks_6.task2.model.Note;

public class Tools {
    public static void main(String[] args) throws Exception {
        createNotes();
    }

    public static void createNotes() throws Exception {
        List<Note> list = new ArrayList<>();
        list.add(new Note("theme1", LocalDate.parse("2019-10-21"), "email1@mail.com", "message1"));
        list.add(new Note("theme2", LocalDate.parse("2019-10-21"), "email2@mail.com", "message2"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("by\\java_intro\\tasks_6\\task2\\notes.dat"));
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
    }

}