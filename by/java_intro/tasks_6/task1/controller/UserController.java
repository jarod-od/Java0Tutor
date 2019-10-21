package by.java_intro.tasks_6.task1.controller;

import by.java_intro.tasks_6.task1.model.User;
import by.java_intro.tasks_6.task1.util.Util;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserController {

    String login;
    String hash;
    boolean isAdmin;

    public void startMainMenu() {
        initUser();
        MenuController menuController = new MenuController();
        if (isAdmin) {
            menuController.runAdminMenu();
        } else {
            menuController.runUserMenu();
        }
    }

    private void initUser() {
        System.out.println("Welcome to our library!");
        while (true) {
            getLogin();
            getPass();

            if (checkUser()) {
                System.out.println("Hello " + login);
                break;
            } else {
                System.out.println("Incorrect user!");
            }
        }
    }
    
    private String getStringFromConsole() {
        String result = null;
        try {
            Scanner s = new Scanner(System.in);
            result = s.nextLine();
        } catch (NoSuchElementException | IllegalStateException e) {
            //e.printStackTrace();
        }
        return result;
    }

    private void getLogin() {
        while(true) {
            System.out.println("Input login: ");
            if ((login = getStringFromConsole()) != null) {
                break;
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    private void getPass() {
        while(true) {
            System.out.println("Input password: ");
            if ((hash = getStringFromConsole()) != null) {
                break;
            } else {
                System.out.println("Wrong input!");
            }
        }
        hash = Util.getHash(hash);
    }

    private boolean checkUser() {
        boolean ans = false;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("by\\java_intro\\tasks_6\\task1\\users.dat"))) {
            List userList = (List) objectInputStream.readObject();
            for(Object obj : userList) {
                User user = (User) obj;
                if (user.getLogin().equals(login) && user.getHash().equals(hash)) {
                    isAdmin = user.isAdmin();
                    ans = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ans;
    }

}