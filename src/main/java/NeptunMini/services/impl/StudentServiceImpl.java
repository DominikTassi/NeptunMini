package NeptunMini.services.impl;

import NeptunMini.entity.Subject;
import NeptunMini.repository.StudentRepository;
import NeptunMini.entity.Student;
import NeptunMini.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        Iterable<Student> allStudent = studentRepository.findAll();

        List<Student> studentList = new ArrayList<>();
        for(Student student : allStudent){
            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }


}
