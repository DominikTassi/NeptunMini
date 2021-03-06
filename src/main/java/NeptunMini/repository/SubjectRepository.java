package NeptunMini.repository;

import NeptunMini.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    Subject getBySubjectId(String subjectId);
}