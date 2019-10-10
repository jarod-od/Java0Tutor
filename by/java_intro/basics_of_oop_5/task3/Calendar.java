package by.java_intro.basics_of_oop_5.task3;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Calendar {

    private List<Holyday> holydays;

    public Calendar() {
        holydays = new ArrayList<>();
    }

    private class Holyday {
        String title;
        LocalDate date;
        public Holyday(String title, LocalDate date) {
            this.title = title;
            this.date = date;
        }

        public String toString() {
            return "Title: " + title + ", date: " + date;
        }
    }

    public void addHolyday(String title, LocalDate date) {
        holydays.add(new Holyday(title, date));
        System.out.println("Added holyday: " + title + ", date = " + date);
    }

    public void printHolydaysInRange(LocalDate from, LocalDate to) {
        System.out.println("Holydays in range: from " + from + ", to " + to);
        for (Holyday holyday : holydays) {
            if(holyday.date.compareTo(from) > 0 && holyday.date.compareTo(to) < 0) {
                System.out.println(holyday);
            }
        }
    }


}