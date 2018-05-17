package NeptunMini.services;

import NeptunMini.entity.Student;
import NeptunMini.entity.Subject;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public void addStudent(Student student);
    public Student getStudentById(String id);
    public void addMark(String stuid, String subid, int mark);
    public void addSubjectToStudent(String studentId, Subject subject);
}
