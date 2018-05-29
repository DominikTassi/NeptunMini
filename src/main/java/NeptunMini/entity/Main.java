package NeptunMini.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main( String[] args ) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        Student student = ctx.getBean(Student.class);

        RegisteredSubject registeredSubject = ctx.getBean(RegisteredSubject.class);

        Subject subject = ctx.getBean(Subject.class);
    }
}

