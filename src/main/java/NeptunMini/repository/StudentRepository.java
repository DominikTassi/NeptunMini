package NeptunMini.repository;

import NeptunMini.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student getByStudentId(String id);
}
