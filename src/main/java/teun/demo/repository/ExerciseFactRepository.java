package teun.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import teun.demo.domain.ExerciseFact;

import java.util.List;

public interface ExerciseFactRepository extends CrudRepository<ExerciseFact, Long> {

    @Query(
            value = "select * from exercise_fact where user_id = :userId and exercise_id = :exerciseId",
            nativeQuery = true)
    List<ExerciseFact> findExerciseFactByUserIdAndExerciseId(@Param("userId") Long userId, @Param("exerciseId") Long exerciseId);
}
