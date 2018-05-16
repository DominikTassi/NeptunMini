package NeptunMini.services.impl;

import NeptunMini.entity.RegisteredSubject;
import NeptunMini.repository.RegisteredSubjectRepository;
import NeptunMini.services.RegisteredSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RegisteredSubjectImpl implements RegisteredSubjectService {
    private RegisteredSubjectRepository registeredSubjectRepository;

    @Autowired
    public RegisteredSubjectImpl(RegisteredSubjectRepository registeredSubjectRepository) {
        this.registeredSubjectRepository = registeredSubjectRepository;
    }

    @Override
    public List<RegisteredSubject> getAllRegistratedSubject() {
        Iterable<RegisteredSubject> allRegistratedSubject = registeredSubjectRepository.findAll();

        List<RegisteredSubject> studentList = new ArrayList<>();
        for(RegisteredSubject registeredSubject : studentList){
            studentList.add(registeredSubject);
        }
        return studentList;
    }

    @Override
    public void addSubject(RegisteredSubject registeredSubject) {
        registeredSubjectRepository.save(registeredSubject);
    }
}
