package NeptunMini.services.impl;

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
        Iterable<Student> allMotor = studentRepository.findAll();

        List<Student> studentList = new ArrayList<>();
        for(Student motor : allMotor){
            studentList.add(motor);
        }
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

}
