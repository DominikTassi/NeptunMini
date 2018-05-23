package NeptunMini;

import NeptunMini.entity.RegisteredSubject;
import NeptunMini.entity.Student;
import NeptunMini.entity.Subject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentTest {
    private Student testStudent = null;
    private List<RegisteredSubject> registeredSubjects = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        testStudent = new Student("QLNW5K", "Test");
    }

    @Test
    public void getStudentId() throws Exception{
        assertEquals(testStudent.getStudentId(), "QLNW5K");
    }

    @Test
    public void setStudentId() throws Exception{
        testStudent.setStudentId("123ABC");
        assertEquals(testStudent.getStudentId(), "123ABC");
    }

    @Test
    public void getStudentName() throws Exception{
        assertEquals(testStudent.getStudentName(), "Test");
    }


    @Test
    public void setStudentName() throws Exception{
        testStudent.setStudentName("NewUser");
        assertEquals(testStudent.getStudentName(), "NewUser");
    }


    @Test
    public void setRegisteredSubjects() throws Exception{
        List<RegisteredSubject> localregsub = new ArrayList<>();
        localregsub.add(new RegisteredSubject(new Subject("GEAIL-123B", "OS", 5), 2));
        testStudent.setRegisteredSubjects(localregsub);
        assertEquals(localregsub, testStudent.getRegisteredSubjects());
    }


    @Test
    public void addRegistratedSubject() throws Exception{
        RegisteredSubject localregsub = new RegisteredSubject(new Subject("GEAIL-123B", "OS", 5), 2);
        testStudent.addRegisteredSubjects(localregsub);
        assertEquals(localregsub, testStudent.getRegisteredSubjects().get(0));
    }


}
