package by.java_intro.programming_with_classes_4.class6;
/**
 *  6.  Составьте  описание  класса для  представления  времени.  
 * Предусмотрте  возможности  установки времени  и  изменения его отдельных полей (час, минута, секунда) 
 * с проверкой допустимости вводимых значений. 
 * В случае  недопустимых  значений  полей  поле  устанавливается  в  значение  0.  
 * Создать  методы  изменения  времени  на  заданное количество часов, минут и секунд. 
 */

public class Time {
    private int hour;
    private int min;
    private int sec;
    public Time() {
        this.hour = 0;
        this.min = 0;
        this.sec = 0;
    }
    public Time(int hour, int min, int sec) {
        if (hour >= 0 && hour < 24) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
        if (min >= 0 && min < 60) {
            this.min = min;
        } else {
            this.min = 0;
        }
        if (sec >= 0 && sec < 60) {
            this.sec = sec;
        } else {
            this.sec = 0;
        }
    }
    public void setHour(int hour) {
        if (hour >= 0 && hour < 24) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
    }
    public void setMin(int min) {
        if (min >= 0 && min < 60) {
            this.min = min;
        } else {
            this.min = 0;
        }
    }
    public void setSec(int sec) {
        if (sec >= 0 && sec < 60) {
            this.sec = sec;
        } else {
            this.sec = 0;
        }
    }
    private int getNormalHour(int hour) {
        if (hour > 23) {
            return hour % 24;
        } else if (hour < 0) {
            return (hour % 24) + 24;
        } else {
            return hour;
        }
    }
    private int getNormalMinOrSec(int minOrSec) {
        if (minOrSec > 59) {
            return minOrSec % 60;
        } else if (minOrSec < 0) {
            return (minOrSec % 60) + 60;
        } else {
            return minOrSec;
        }
    }
    public void decrHour(int diffValue) {
        this.hour -= diffValue;
        this.hour = getNormalHour(this.hour);
    }
    public void decrMin(int diffValue) {
        this.min -= diffValue;
        this.min = getNormalMinOrSec(this.min);
    }
    public void decrSec(int diffValue) {
        this.sec -= diffValue;
        this.sec = getNormalMinOrSec(this.sec);
    }

    public void incrHour(int diffValue) {
        this.hour += diffValue;
        this.hour = getNormalHour(this.hour);
    }
    public void incrMin(int diffValue) {
        this.min += diffValue;
        this.min = getNormalMinOrSec(this.min);
    }
    public void incrSec(int diffValue) {
        this.sec += diffValue;
        this.sec = getNormalMinOrSec(this.sec);
    }
}