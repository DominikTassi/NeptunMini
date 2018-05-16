package NeptunMini.controllers.model;

import NeptunMini.entity.Subject;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegisteredSubjectModel {
    @NotNull
    private Subject subject;
    @NotNull
    private int mark;


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

    @Override
    public String toString() {
        return "RegisteredSubjectModel{" +
                "subject=" + subject +
                ", mark=" + mark +
                '}';
    }
}
