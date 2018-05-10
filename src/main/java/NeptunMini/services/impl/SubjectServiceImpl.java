package NeptunMini.services.impl;

import NeptunMini.repository.SubjectRepository;
import NeptunMini.entity.Subject;
import NeptunMini.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private SubjectRepository subjectRepository;

    @Autowired
    public void setSubjectRepository(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getAllSubject() {
        Iterable<Subject> allSubject = subjectRepository.findAll();

        List<Subject> subjectList = new ArrayList<>();
        for (Subject subject : allSubject){
            subjectList.add(subject);
        }
        return subjectList;
    }

    @Override
    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }



}
