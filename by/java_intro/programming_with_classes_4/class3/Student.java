package by.java_intro.programming_with_classes_4.class3;
/**
 *  3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, 
 * номер группы, успеваемость (массив  из пяти элементов). 
 * Создайте массив из десяти элементов такого типа. 
 * Добавьте возможность вывода фамилий и  номеров групп студентов, имеющих оценки, равные только 9 или 10. 
 */

public class Student {
    private String initials;
    private String surName;
    private int groupNumber;
    private int[] rating;
    
    public Student(String initials, String surName, int groupNumber, int[] rating) throws WrongRatingArraySizeException {
        if (rating.length != 5) {
            throw new WrongRatingArraySizeException();
        }
        this.initials = initials;
        this.surName = surName;
        this.groupNumber = groupNumber;
        this.rating = rating;
    }

    public void printSurNameAndGroupNumber() {
        System.out.println("Surname: " + surName + ", group number: " + groupNumber);
    }

    public static void printGoodStudents(Student[] students) throws EmptyStudentsArrayException {
        if (students == null) {
            throw new EmptyStudentsArrayException();
        }
        for (int i = 0; i < students.length; i++) {
            boolean isGood = true;
            for (int r : students[i].rating) {
                if (r < 9) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) {
                students[i].printSurNameAndGroupNumber();
            }
        }
    }

    public static void main(String[] args) {
        int[] r1 = new int[] {9, 9, 10, 9, 10};
        int[] r2 = new int[] {2, 3, 10, 5, 6};
        try {
            Student[] s = new Student[10];
            for (int i = 0; i < s.length; i++) {
                s[i] = new Student("name" + i, "surName" + i, i, i % 2 == 0 ? r1 : r2);
            }
            Student.printGoodStudents(s);
        } catch (StudentClassExeption e) {
            e.printStackTrace();
        }


    }
}

class StudentClassExeption extends Exception {}

class WrongRatingArraySizeException extends StudentClassExeption {}

class EmptyStudentsArrayException extends StudentClassExeption {}