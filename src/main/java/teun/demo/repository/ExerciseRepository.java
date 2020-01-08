package teun.demo.repository;

import org.springframework.data.repository.CrudRepository;
import teun.demo.domain.Exercise;

public interface ExerciseRepository extends CrudRepository<Exercise, String> {


}
