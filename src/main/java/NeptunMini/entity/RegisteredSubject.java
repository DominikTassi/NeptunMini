package NeptunMini.entity;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class RegisteredSubject implements Serializable {
    private Subject subject;
    private int mark;


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

}
