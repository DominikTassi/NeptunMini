package NeptunMini.controllers.model;

import NeptunMini.entity.RegisteredSubject;
import lombok.Data;

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

    private List<RegisteredSubject> registeredSubjects = new ArrayList<>();


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

    @Override
    public String toString() {
        return "StudentModel{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", registeredSubjects=" + registeredSubjects +
                '}';
    }
}
