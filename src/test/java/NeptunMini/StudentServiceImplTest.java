package NeptunMini;

import NeptunMini.entity.Main;
import NeptunMini.entity.RegisteredSubject;
import NeptunMini.entity.Student;
import NeptunMini.entity.Subject;
import NeptunMini.repository.StudentRepository;
import NeptunMini.repository.SubjectRepository;
import NeptunMini.services.StudentService;
import NeptunMini.services.SubjectService;
import NeptunMini.services.impl.StudentServiceImpl;
import NeptunMini.services.impl.SubjectServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class StudentServiceImplTest {

    private StudentService studentService;
    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;
    private SubjectService subjectService;

    @Before
    public void setUp(){
        studentRepository = Mockito.mock(StudentRepository.class);
        studentService = new StudentServiceImpl(studentRepository);

        subjectRepository = Mockito.mock(SubjectRepository.class);
        subjectService = new SubjectServiceImpl(subjectRepository);
    }

    @Test
    public void getNullStudent() throws Exception {
        Mockito.when(studentRepository.getByStudentId("noId")).thenReturn(null);

        Student student = studentService.getStudentById("noId");

        assertNull(student);

        Mockito.verify(studentRepository, Mockito.times(1)).getByStudentId("noId");
    }


    @Test
    public void getNullSubject() throws Exception {
        Mockito.when(subjectRepository.getBySubjectId("noId")).thenReturn(null);

        Subject subject = subjectService.getSubjectById("noId");

        assertNull(subject);
    }

    @Test
    public void getAllSubjectEmpty() throws Exception {

        Mockito.when(subjectService.getAllSubject()).thenReturn(Collections.emptyList());

        List<Subject> subjects = subjectService.getAllSubject();

        assertEquals(subjects, Collections.emptyList());

    }


}