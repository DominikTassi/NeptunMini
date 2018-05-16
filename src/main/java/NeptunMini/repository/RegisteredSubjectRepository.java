package NeptunMini.repository;

import NeptunMini.entity.RegisteredSubject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredSubjectRepository extends CrudRepository<RegisteredSubject, Integer> {
}
