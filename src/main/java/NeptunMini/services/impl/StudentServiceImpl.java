package NeptunMini.services.impl;

import NeptunMini.entity.RegisteredSubject;
import NeptunMini.entity.Subject;
import NeptunMini.repository.StudentRepository;
import NeptunMini.entity.Student;
import NeptunMini.repository.SubjectRepository;
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
        return studentRepository.getByStudentId(id);
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

    @Override
    public void deleteSubjectFromStudent(String studentId, String subjectId) {
        Student student = getStudentById(studentId);
        List<RegisteredSubject> subjects = getStudentById(studentId).getRegisteredSubjects();
        for(int i = 0; i < subjects.size(); i++){
            if(subjects.get(i).getSubject().getSubjectId().equals(subjectId)){
                subjects.remove(subjects.get(i));
            }
        }
        student.setRegisteredSubjects(subjects);

        studentRepository.save(student);
    }

    @Override
    public boolean studentHasThis(Student student, Subject subject) {
        List<RegisteredSubject> registeredSubjects = student.getRegisteredSubjects();
        for(int i = 0; i < registeredSubjects.size(); i++){
            if(registeredSubjects.get(i).getSubject().equals(subject)){
                return true;
            }
        }
        return false;
    }


}
