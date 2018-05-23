package NeptunMini.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Subject implements Serializable {
    @Id
    private String subjectId;
    private String subjectName;
    private int credit;

    public Subject(String subjectId, String subjectName, int credit) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.credit = credit;
    }

    public Subject() {
    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return credit == subject.credit &&
                Objects.equals(subjectId, subject.subjectId) &&
                Objects.equals(subjectName, subject.subjectName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(subjectId, subjectName, credit);
    }
}
