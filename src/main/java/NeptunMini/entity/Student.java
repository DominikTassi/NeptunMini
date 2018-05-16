package NeptunMini.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student implements Serializable {
    @Id
    private String studentId;
    private String studentName;

    @OneToMany(cascade= CascadeType.ALL)
    private List<RegisteredSubject> registeredSubjects = new ArrayList<>();

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<RegisteredSubject> getRegisteredSubjects() {
        return registeredSubjects;
    }

    public void setRegisteredSubjects(List<RegisteredSubject> registeredSubjects) {
        this.registeredSubjects = registeredSubjects;
    }

    public void addRegisteredSubjects(RegisteredSubject registeredSubject){
        registeredSubjects.add(registeredSubject);
    }

    public Student() {
    }
}
