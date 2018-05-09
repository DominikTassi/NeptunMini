package NeptunMini.controllers.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SubjectModel {
    @NotNull
    @Size(min = 4, max = 10)
    private String subjectId;

    @NotNull
    @Size(max = 100)
    private String subjectName;

    @NotNull
 //   @Range(min = 0, max = 15)
    private int credit;

    @NotNull
   // @Range(min = 1, max = 5)
    private int mark;


    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "SubjectModel{" +
                "subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", credit=" + credit +
                '}';
    }

}
