package by.java_intro.tasks_6.task3.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import by.java_intro.tasks_6.task3.model.StudentFile;
import by.java_intro.tasks_6.task3.model.StudentFiles;

/**
 * Menu
 */
public class Menu {

    private boolean isAdmin = false;
    private BufferedReader in;
    private PrintWriter out;
    StudentFilesController studentFilesController;

    public Menu(boolean isAdmin, BufferedReader in, PrintWriter out) {
        this.isAdmin = isAdmin;
        this.in = in;
        this.out = out;
        studentFilesController = new StudentFilesController();
    }

    public void runMainMenu() {
        try {
            if (isAdmin) {
                runAdminMenu();
            } else {
                runUserMenu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runAdminMenu() throws Exception {
        while (true) {
            out.println("Input action (1 - view, 2 - add, 3 - exit)");
            out.flush();
            String s = in.readLine();
            switch(s) {
                case "1": 
                    runViewMenu();
                    break;
                case "2": 
                    runAddStudent();
                    break;
            }
            if (s.equals("3")) {
                break;
            }

        }
    }

    private void runUserMenu() throws Exception  {
        runViewMenu();
    }

    private void runViewMenu() throws Exception {
        while (true) {
            out.println("Input action (1 - view all, 2 - search, 3 - exit)");
            out.flush();
            String s = in.readLine();
            if (s.equals("1")) {
                runViewAll();
            } else if (s.equals("2")) {
                runSearch();
            } else if (s.equals("3")) {
                break;
            }
        }
    }

    private void runViewAll() {
        System.out.println("Sending student files to client");
        out.println("Students files:");
        for (StudentFile studentFile : studentFilesController.getList()) {
            System.out.println("Sending: " + studentFile);
            out.println(studentFile);
        }
        out.flush();
    }

    private void runViewStudentFile(StudentFile studentFile) {
        System.out.println("Sending concrete student file to client");
        out.println("Student file:");
        System.out.println("Sending: " + studentFile);
        out.println(studentFile);
        out.flush();
    }

    private void runSearch() throws Exception {
        out.println("Input surname:");
        out.flush();
        String surname = in.readLine();

        out.println("Input lastname:");
        out.flush();
        String lastname = in.readLine();

        int group = -1;
        while(true) {
            try {
                out.println("Input group:");
                out.flush();
                String s = in.readLine();
                if (s.equals("")) {
                    break;
                } else {
                    group = Integer.parseInt(s);
                    if (group > 0) {
                        break;
                    } else {
                        out.println("Group must be positive:");
                        out.flush();
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        
        StudentFile studentFile = studentFilesController.find(surname, lastname, group);
        
        if (studentFile != null) {
            runViewStudentFile(studentFile);
            if (isAdmin) {
                runMenuAfterSearch();
            }
        } else {
            out.println("student not found");
            out.flush();
        }
    }

    private void runMenuAfterSearch() throws Exception{
        while (true) {
            out.println("Input action (1 - edit, else - exit search)");
            out.flush();
            String s = in.readLine();
            if (s.equals("1")) {
                runEditStudent();
                break;
            } else {
                break;
            }
        }
    }

    private void runEditStudent() throws Exception {
        out.println("Input new surname:");
        out.flush();
        String surname = in.readLine();

        out.println("Input new lastname:");
        out.flush();
        String lastname = in.readLine();

        int group = -1;
        while(true) {
            try {
                out.println("Input new group:");
                out.flush();
                String s = in.readLine();
                if (s.equals("")) {
                    break;
                } else {
                    group = Integer.parseInt(s);
                    if (group > 0) {
                        break;
                    } else {
                        out.println("Group must be positive:");
                        out.flush();
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        
        if (studentFilesController.editLastSearchStudent(surname, lastname, group)) {
            out.println("student edited");
            out.flush();
        } else {
            out.println("error, student didnt edit");
            out.flush();
        }
    }

    private void runAddStudent() throws Exception {
        String surname, lastname;
        int group;
        while(true) {
            out.println("Input surname:");
            out.flush();
            surname = in.readLine();
            if (!surname.equals("")) {
                break;
            }
        }

        while(true) {
            out.println("Input lastname:");
            out.flush();
            lastname = in.readLine();
            if (!lastname.equals("")) {
                break;
            }
        }
        

        while(true) {
            try {
                out.println("Input group:");
                out.flush();
                String s = in.readLine();
                if (!s.equals("")) {
                    group = Integer.parseInt(s);
                    if (group > 0) {
                        break;
                    } else {
                        out.println("Group must be positive:");
                        out.flush();
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        
        if (studentFilesController.addStudent(surname, lastname, group)) {
            out.println("student added");
            out.flush();
        } else {
            out.println("error, student didnt add");
            out.flush();
        }
    }
}