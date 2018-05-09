package NeptunMini.controllers.model;

import lombok.Data;
import NeptunMini.entity.Subject;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentModel {
    @NotNull
    @Size(min = 6, max = 6)
    String studentId;

    @NotNull
    @Size(max = 100)
    String studentName;

    List<Subject> subjects = new ArrayList<>();


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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
