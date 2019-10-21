package by.java_intro.tasks_6.task1.model;

import java.io.Serializable;;

public class User implements Serializable {
    private String login;
    private String hash;
    private boolean isAdmin;

    public User(String login, String hash, boolean isAdmin) {
        this.login = login;
        this.hash = hash;
        this.isAdmin = isAdmin;
    }

    public String getLogin() {
        return login;
    }

    public String getHash() {
        return hash;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}