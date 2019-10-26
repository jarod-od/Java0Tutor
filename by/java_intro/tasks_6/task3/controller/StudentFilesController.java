package by.java_intro.tasks_6.task3.controller;

import java.io.File;
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
 * StudentFilesController
 */
public class StudentFilesController {

    private StudentFiles studentFiles;
    private int lastFoundIndex;

    public StudentFilesController() {
        getStudentFiles();
    }

    public List<StudentFile> getList() {
        return studentFiles.list;
    }

    /*public List<StudentFile> find(String surname, String lastname, int group) {
        List<StudentFile> found = new ArrayList<>();
        for(StudentFile studentFile : studentFiles.list) {

            boolean isSurnameFit = false;
            boolean isLastnameFit = false;
            boolean isGroupFit = false;

            if(!surname.equals("")) {
                if (studentFile.getSurname().equals(surname)) {
                    isSurnameFit = true;
                }
            } else {
                isSurnameFit = true;
            }

            if(!lastname.equals("")) {
                if (studentFile.getLastname().equals(lastname)) {
                    isLastnameFit = true;
                }
            } else {
                isLastnameFit = true;
            }

            if(group != -1) {
                if (studentFile.getGroupId() == group) {
                    isGroupFit = true;
                }
            } else {
                isGroupFit = true;
            }

            if (isSurnameFit && isLastnameFit && isGroupFit) {
                found.add(studentFile);
            }
            
        }
        return found;
    }*/

    public StudentFile find(String surname, String lastname, int group) {
        lastFoundIndex = 0;
        boolean isStudentFound = false;
        for(StudentFile studentFile : studentFiles.list) {

            boolean isSurnameFit = false;
            boolean isLastnameFit = false;
            boolean isGroupFit = false;

            if(!surname.equals("")) {
                if (studentFile.getSurname().equals(surname)) {
                    isSurnameFit = true;
                }
            } else {
                isSurnameFit = true;
            }

            if(!lastname.equals("")) {
                if (studentFile.getLastname().equals(lastname)) {
                    isLastnameFit = true;
                }
            } else {
                isLastnameFit = true;
            }

            if(group != -1) {
                if (studentFile.getGroupId() == group) {
                    isGroupFit = true;
                }
            } else {
                isGroupFit = true;
            }

            if (isSurnameFit && isLastnameFit && isGroupFit) {
                isStudentFound = true;
                break;
            }
            lastFoundIndex++;
        }
        if (isStudentFound) {
            return studentFiles.list.get(lastFoundIndex);
        } else {
            return null;
        }
        
    }

    public boolean editLastSearchStudent(String surname, String lastname, int group) {
        StudentFile studentFileOld = studentFiles.list.get(lastFoundIndex);

        if(surname.equals("")) {
            surname = studentFileOld.getSurname();
        }

        if(lastname.equals("")) {
            lastname = studentFileOld.getLastname();
        }

        if(group == -1) {
            group = studentFileOld.getGroupId();
        }

        StudentFile studentFileNew = new StudentFile(surname, lastname, group);
        try {
            studentFiles.list.set(lastFoundIndex, studentFileNew);
            if (writeStudentFiles()) {
                return true;
            } else {
                studentFiles.list.set(lastFoundIndex, studentFileOld);
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addStudent(String surname, String lastname, int group) {

        StudentFile studentFile = new StudentFile(surname, lastname, group);
        try {
            studentFiles.list.add(studentFile);
            if (writeStudentFiles()) {
                return true;
            } else {
                studentFiles.list.remove(studentFiles.list.size() - 1);
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private void getStudentFiles() {
        try {
            File xmlFile = new File("by\\java_intro\\tasks_6\\task3\\student_files.xml");
            studentFiles = JAXB.unmarshal(xmlFile, StudentFiles.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean writeStudentFiles() {
        try {
            StringWriter sw = new StringWriter();
            JAXB.marshal(studentFiles, sw);
            Path path = Paths.get("by\\java_intro\\tasks_6\\task3\\student_files.xml");
            Files.write(path, sw.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}