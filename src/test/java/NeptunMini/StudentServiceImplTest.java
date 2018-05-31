package NeptunMini;

import NeptunMini.entity.Main;
import NeptunMini.entity.RegisteredSubject;
import NeptunMini.entity.Student;
import NeptunMini.entity.Subject;
import NeptunMini.repository.StudentRepository;
import NeptunMini.services.StudentService;
import NeptunMini.services.impl.StudentServiceImpl;
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
import java.util.Optional;


public class StudentServiceImplTest {

    private StudentService studentService;
    private StudentRepository studentRepository;

    @Before
    public void setUp(){
        studentRepository = Mockito.mock(StudentRepository.class);
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    public void getStudent() throws Exception {
        Mockito.when(studentRepository.getByStudentId("noId")).thenReturn(null);
      //  Mockito.doAnswer(returnsFirstArg()))
    }

}