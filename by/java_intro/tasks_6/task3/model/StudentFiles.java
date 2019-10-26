package by.java_intro.tasks_6.task3.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Files
 */
@XmlRootElement  (name = "student_files")
public class StudentFiles {

    @XmlElement (name = "student_file")
    public List<StudentFile> list;

    public StudentFiles(List<StudentFile> list) {
        this.list = list;
    }

    public StudentFiles() {}

    @Override
    public String toString() {
        return "{" +
            " list='" + list + "'" +
            "}";
    }

}