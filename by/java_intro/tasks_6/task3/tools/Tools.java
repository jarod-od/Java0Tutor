package by.java_intro.tasks_6.task3.tools;

import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;

import by.java_intro.tasks_6.task3.model.StudentFile;
import by.java_intro.tasks_6.task3.model.StudentFiles;

/**
 * Tools
 */
public class Tools {

    public static void main(String[] args) {
        createStudents();
    }

    static void createStudents() {
        try
        {
            StringWriter out = new StringWriter();
            List<StudentFile> list = new ArrayList<>();
            list.add(new StudentFile("surname1", "lastname1", 1));
            list.add(new StudentFile("surname2", "lastname2", 2));
            list.add(new StudentFile("surname3", "lastname3", 3));
            StudentFiles studentFiles = new StudentFiles(list);

            JAXB.marshal(studentFiles, out);

            writeToFile(out.toString());
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeToFile(String string) {
        try {
            Path path = Paths.get("by\\java_intro\\tasks_6\\task3\\student_files.xml");
            Files.write(path, string.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}