package by.java_intro.tasks_6.task2.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * (тема, дата создания, e-mail, сообщение).     
 */
public class Note implements Serializable {
    private String theme;
    private LocalDate date;
    private String email;
    private String message;

    public Note(String theme, LocalDate date, String email, String message) {
        this.theme = theme;
        this.date = date;
        this.email = email;
        this.message = message;
    }

    public String getTheme() {
        return this.theme;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMessage() {
        return this.message;
    }


    @Override
    public String toString() {
        return "{" +
            " theme='" + getTheme() + "'" +
            ", date='" + getDate() + "'" +
            ", email='" + getEmail() + "'" +
            ", message='" + getMessage() + "'" +
            "}";
    }

}