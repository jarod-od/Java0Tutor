package by.java_intro.basics_of_oop_5.task3;

import java.time.LocalDate;

/**
 * 2. Создать класс Календарь с внутренним классом, 
 * с помощью объектов которого можно хранить информацию о  выходных и праздничных днях. 
 */

public class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        calendar.addHolyday("holyday1", LocalDate.parse("2019-10-12"));
        calendar.addHolyday("holyday2", LocalDate.parse("2019-10-13"));
        calendar.addHolyday("holyday3", LocalDate.parse("2019-10-19"));
        calendar.addHolyday("holyday4", LocalDate.parse("2019-10-20"));
        calendar.printHolydaysInRange(LocalDate.parse("2019-10-09"), LocalDate.parse("2019-10-14"));
    }
}