package NeptunMini.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class RegisteredSubject implements Serializable {
    private int id;
    private Subject subject;
    private int mark;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public RegisteredSubject(Subject subject, int mark) {
        this.subject = subject;
        this.mark = mark;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public RegisteredSubject() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisteredSubject that = (RegisteredSubject) o;
        return id == that.id &&
                mark == that.mark &&
                Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, subject, mark);
    }
}
