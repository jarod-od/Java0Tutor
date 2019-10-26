package by.java_intro.tasks_6.task3.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentFile {

    @XmlElement
    private String surname;
    @XmlElement
    private String lastname;
    @XmlElement
    private int groupId;

    public StudentFile() {

    }

    public StudentFile(String surname, String lastname, int groupId) {
        this.surname = surname;
        this.lastname = lastname;
        this.groupId = groupId;
    }
    
    public String getSurname() {
        return this.surname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public int getGroupId() {
        return this.groupId;
    }

    @Override
    public String toString() {
        return "{" +
            " surname='" + getSurname() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", groupId='" + getGroupId() + "'" +
            "}";
    }

}