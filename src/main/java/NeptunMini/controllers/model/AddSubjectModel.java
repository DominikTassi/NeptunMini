package NeptunMini.controllers.model;


import javax.validation.constraints.NotNull;

public class AddSubjectModel {
    @NotNull
    private String studentId;
    @NotNull
    private String subjectId;


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

    @Override
    public String toString() {
        return "AddSubjectModel{" +
                "studentId='" + studentId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                '}';
    }
}
