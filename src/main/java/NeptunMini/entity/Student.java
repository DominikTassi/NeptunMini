package NeptunMini.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student implements Serializable {
    @Id
    private String studentId;
    private String studentName;

    @OneToMany(targetEntity=Subject.class, fetch=FetchType.EAGER)
    private List<Subject> subjects = new ArrayList<>();

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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public void addMark(String subjectId, int mark){
        for(int i = 0; i <= subjects.size(); i++){
            if(subjects.get(i).getSubjectId().equals(subjectId))
                subjects.get(i).setMark(mark);
        }
    }

    public Student() {
    }
}
