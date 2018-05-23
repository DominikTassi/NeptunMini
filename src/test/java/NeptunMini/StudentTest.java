package NeptunMini;

import NeptunMini.entity.Student;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private Student testStudent = null;

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




}
