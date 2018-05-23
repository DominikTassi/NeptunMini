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

public class RegisteredSubjectTest{

    private RegisteredSubject test = null;

    @Before
    public void setUp() throws Exception{
        test = new RegisteredSubject(new Subject("ABC123","Test",5), 2);
    }

    @Test
    public void getSubject() throws Exception{
        Subject testSubject = new Subject("ABC123","Test",5);
        assertTrue(testSubject.equals(test.getSubject()));
    }

    @Test
    public void getSubjectId() throws Exception{
        assertEquals(test.getSubject().getSubjectId(), "ABC123");
    }

    @Test
    public void getSubjectName() throws Exception{
        assertEquals(test.getSubject().getSubjectName(), "Test");
    }

    @Test
    public void getMark() throws Exception{
        assertEquals(test.getMark(), 2);
    }

    @Test
    public void setMark() throws Exception{
        test.setMark(5);
        assertEquals(test.getMark(), 5);
    }


}
