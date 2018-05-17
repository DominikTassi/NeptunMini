package NeptunMini.services;

import NeptunMini.entity.Subject;

import java.util.List;

public interface SubjectService {
    public List<Subject> getAllSubject();
    public void addSubject(Subject subject);
    public Subject getSubjectById(String id);
}
