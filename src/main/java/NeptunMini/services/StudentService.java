package NeptunMini.services;

import NeptunMini.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public void addStudent(Student student);
}
