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

public class SubjectTest {
    private Subject test = null;

    @Before
    public void setUp() throws Exception{
        test = new Subject("ABC123", "Test", 5);
    }

    @Test
    public void getSubjectId() throws Exception{
        assertEquals(test.getSubjectId(), "ABC123");
    }


    @Test
    public void getSubjectName() throws Exception{
        assertEquals(test.getSubjectId(), "Test");
    }


    @Test
    public void setSubjectId() throws Exception{
        test.setSubjectId("NEW123");
        assertEquals(test.getSubjectId(), "NEW123");
    }

    @Test
    public void setSubjectName() throws Exception{
        test.setSubjectName("newTest");
        assertEquals(test.getSubjectName(), "newTest");
    }


}
