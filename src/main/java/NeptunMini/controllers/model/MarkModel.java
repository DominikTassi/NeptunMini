package NeptunMini.controllers.model;

import lombok.Builder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MarkModel {
    @NotNull
    @Size(min = 6, max = 6)
    String studentId;

    @NotNull
    String subjectId;

    @NotNull
    int mark;


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "MarkModel{" +
                "studentId='" + studentId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", mark=" + mark +
                '}';
    }
}
