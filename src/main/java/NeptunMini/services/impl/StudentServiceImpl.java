package NeptunMini.services.impl;

import NeptunMini.entity.RegisteredSubject;
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

    @Override
    public Student getStudentById(String id) {
        Iterable<Student> allStudent= studentRepository.findAll();

        while (allStudent.iterator().hasNext()) {
            Student stu = allStudent.iterator().next();
            if(stu.getStudentId().equals(id)){
                return stu;
            }
        }
        return null;
    }

    @Override
    public void addMark(String stuid, String subid, int mark) {
       List<RegisteredSubject> subjects = new ArrayList<>();
       subjects = getStudentById(stuid).getRegisteredSubjects();
       for(int i = 0; i < subjects.size(); i++){
           if(subjects.get(i).getSubject().getSubjectId().equals(subid)){
               subjects.get(i).setMark(mark);
           }
       }


       Student student = getStudentById(stuid);
       student.setRegisteredSubjects(subjects);



       studentRepository.save(student);

    }

    @Override
    public void addSubjectToStudent(String studentId, Subject subject) {
        Student student = getStudentById(studentId);
        student.addRegisteredSubjects(new RegisteredSubject(subject, 1));
        studentRepository.save(student);
    }


}
