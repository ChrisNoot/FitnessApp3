package teun.demo.repository;

import org.springframework.data.repository.CrudRepository;
import teun.demo.domain.ExerciseFact;

public interface ExerciseFactRepository extends CrudRepository<ExerciseFact,Long> {
}
