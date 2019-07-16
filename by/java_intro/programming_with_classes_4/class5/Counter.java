package by.java_intro.programming_with_classes_4.class5;
/**
 *  5. Опишите класс, реализующий десятичный счетчик, 
 * который может увеличивать или уменьшать свое значение на единицу в заданном диапазоне.  
 * Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями. 
 * Счетчик имеет методы увеличения и уменьшения состояния, и метод позволяющее получить его текущее состояние. 
 * Написать код, демонстрирующий все возможности класса. 
 */

public class Counter {
    private int counter;
    public Counter() {
        counter = 0;
    }
    public Counter(int counter) {
        if (counter >= 0 && counter < 10) {
            this.counter = counter;
        } else {
            this.counter = 0;
        }
        
    }
    public void increase() {
        if (counter < 9) {
            counter++;
        } else {
            counter = 0;
        }
        
    }
    public void decrease() {
        if (counter > 0) {
            counter--;
        } else {
            counter = 9;
        }
    }
    public int getCurrentValue() {
        return counter;
    }

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter(5);
        System.out.println("Counter 1 value: " + counter1.getCurrentValue());
        System.out.println("Counter 2 value: " + counter2.getCurrentValue());
        for (int i = 0; i < 6; i++) {
            counter1.increase();
            counter2.increase();
        }
        System.out.println("Counter 1 value after 6 incr: " + counter1.getCurrentValue());
        System.out.println("Counter 2 value after 6 incr: " + counter2.getCurrentValue());
        for (int i = 0; i < 7; i++) {
            counter1.decrease();
            counter2.decrease();
        }
        System.out.println("Counter 1 value after 7 decr: " + counter1.getCurrentValue());
        System.out.println("Counter 2 value after 7 decr: " + counter2.getCurrentValue());
    }
}