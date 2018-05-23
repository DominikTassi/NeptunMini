package NeptunMini.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) &&
                Objects.equals(studentName, student.studentName) &&
                Objects.equals(registeredSubjects, student.registeredSubjects);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, studentName, registeredSubjects);
    }
}
