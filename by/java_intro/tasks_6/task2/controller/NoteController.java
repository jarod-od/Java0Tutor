package by.java_intro.tasks_6.task2.controller;

import java.util.List;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import by.java_intro.tasks_6.task2.model.Note;
import by.java_intro.tasks_6.task2.view.View;

public class NoteController {
    private List<Note> notes;

    public NoteController() {
        readNotes();
    }

    private void readNotes() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("by\\java_intro\\tasks_6\\task2\\notes.dat"))) {
            Object data = null;
            List objList = (List) objectInputStream.readObject();
            notes = new ArrayList<>();
            for(Object obj : objList) {
                notes.add((Note) obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNote(String theme, LocalDate date, String email, String message) {
        notes.add(new Note(theme, date, email, message));
    }

    public void showNotesSortedByTitle() {
        //todo
        View.showNotes(notes);
    }

    public void showNotesSortedByData() {
        //todo
        View.showNotes(notes);
    }

    public void saveNotes() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("by\\java_intro\\tasks_6\\task2\\notes.dat"));
            objectOutputStream.writeObject(notes);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}