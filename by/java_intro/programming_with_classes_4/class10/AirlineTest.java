package by.java_intro.programming_with_classes_4.class10;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *  10. Создать класс Airline, спецификация которого приведена ниже. 
 * Определить конструкторы, set-и get-методы и метод  toString(). 
 * Создать второй класс, агрегирующий массив типа Airline, 
 * с подходящими конструкторами и методами. 
 * Задать критерии выбора данных и вывести эти данные на консоль. 
 * Airline: 
 *  пункт назначения, номер рейса, тип самолета, время вылета, дни недели. 
 * Найти и вывести: 
 * a) список рейсов для заданного пункта назначения; 
 * b) список рейсов для заданного дня недели; 
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного
 */

public class AirlineTest {
    public static void main(String[] args) {
        Airline[] airlines = initAirlines(10);
        System.out.println("список всех рейсов: ");
        printAirlines(airlines);

        System.out.println();
        System.out.println("список рейсов для пункта назначения \"destinationPoint3\": ");
        printAirlines(getAirlinesByDestinationPoint(airlines, "destinationPoint3"));

        System.out.println();
        System.out.println("список рейсов для среды: : ");
        printAirlines(getAirlinesByDayOfWeek(airlines, DayOfWeek.WEDNESDAY));

        System.out.println();
        System.out.println("список рейсов для среды, время вылета для которых больше \"11:14\": ");
        printAirlines(getAirlinesByDayOfWeekAndAfterTime(airlines, DayOfWeek.WEDNESDAY, LocalTime.parse("11:14")));
    }

    public static Airline[] initAirlines(int n) {
        Airline[] airlines = new Airline[n];
        for (int i = 0; i < n; i++) {
            airlines[i] = new Airline("destinationPoint" + (i % 4), 
                                      i, 
                                      "planeType" + (i % 3), 
                                      LocalTime.parse("11:1" + (i % 10)), 
                                      new DayOfWeek[]{ DayOfWeek.of(i % 7 + 1), DayOfWeek.of( (i + 1) % 7 + 1) });
        }
        return airlines;
    }

    public static void printAirlines(Airline[] airlines) {
        for (int i = 0; i < airlines.length; i++) {
            System.out.println(airlines[i].toString());
        }
    }

    private static Airline[] getAirlinesByDestinationPoint(Airline[] airlines, String destinationPoint) {
        Airline[] newAirlines = new Airline[airlines.length];
        int k = 0;
        for (int i = 0; i < airlines.length; i++) {
            if (airlines[i].getDestinationPoint().equals(destinationPoint)) {
                newAirlines[k] = airlines[i];
                k++;
            }
        }
        Airline[] resultAirlines = new Airline[k];
        for (int i = 0; i < k; i++) {
            resultAirlines[i] = newAirlines[i];
        }
        return resultAirlines;
    }

    private static Airline[] getAirlinesByDayOfWeek(Airline[] airlines, DayOfWeek dayOfWeek) {
        Airline[] newAirlines = new Airline[airlines.length];
        int k = 0;
        for (int i = 0; i < airlines.length; i++) {
            for (DayOfWeek d : airlines[i].getAirlineDaysOfWeek()) {
                if (d.equals(dayOfWeek)) {
                    newAirlines[k] = airlines[i];
                    k++;
                    break;
                }
            }
        }
        Airline[] resultAirlines = new Airline[k];
        for (int i = 0; i < k; i++) {
            resultAirlines[i] = newAirlines[i];
        }
        return resultAirlines;
    }

    private static Airline[] getAirlinesByDayOfWeekAndAfterTime(Airline[] airlines, DayOfWeek dayOfWeek, LocalTime time) {
        Airline[] newAirlines = new Airline[airlines.length];
        int k = 0;
        for (int i = 0; i < airlines.length; i++) {
            if (airlines[i].getDepartureTime().compareTo(time) > 0) {
                for (DayOfWeek d : airlines[i].getAirlineDaysOfWeek()) {
                    if (d.equals(dayOfWeek)) {
                        newAirlines[k] = airlines[i];
                        k++;
                        break;
                    }
                }
            }
        }
        Airline[] resultAirlines = new Airline[k];
        for (int i = 0; i < k; i++) {
            resultAirlines[i] = newAirlines[i];
        }
        return resultAirlines;
    }
}

class Airline {
    private String destinationPoint;
    private int airlineId;
    private String planeType;
    private LocalTime departureTime;
    private DayOfWeek[] airlineDaysOfWeek; 

    public Airline(String destinationPoint, int airlineId, String planeType, LocalTime departureTime, DayOfWeek[] airlineDaysOfWeek) {
        this.destinationPoint = destinationPoint;
        this.airlineId = airlineId;
        this.planeType = planeType;
        this.departureTime = departureTime;
        this.airlineDaysOfWeek = airlineDaysOfWeek;
    }

    public String getDestinationPoint() {
        return this.destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public int getAirlineId() {
        return this.airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public String getPlaneType() {
        return this.planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public LocalTime getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public DayOfWeek[] getAirlineDaysOfWeek() {
        return this.airlineDaysOfWeek;
    }

    public void setAirlineDaysOfWeek(DayOfWeek[] airlineDaysOfWeek) {
        this.airlineDaysOfWeek = airlineDaysOfWeek;
    }

    @Override
    public String toString() {
        String result =
            "{" +
            " destinationPoint='" + destinationPoint + "'" +
            ", airlineId='" + airlineId + "'" +
            ", planeType='" + planeType + "'" +
            ", departureTime='" + departureTime + "'" +
            ", airlineDaysOfWeek=[";
            for (int i = 0; i < airlineDaysOfWeek.length; i++) {
                if (i != airlineDaysOfWeek.length - 1) {
                    result += airlineDaysOfWeek[i] + ", ";
                } else {
                    result += airlineDaysOfWeek[i];
                }
            }
            result += "]" +
            "}";
        return result;
    }
}