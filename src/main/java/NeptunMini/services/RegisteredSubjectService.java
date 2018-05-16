package NeptunMini.services;

import NeptunMini.entity.RegisteredSubject;

import java.util.List;

public interface RegisteredSubjectService {
    public List<RegisteredSubject> getAllRegistratedSubject();
    public void addSubject(RegisteredSubject registeredSubject);

}
