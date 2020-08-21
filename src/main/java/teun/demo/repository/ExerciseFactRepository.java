package teun.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import teun.demo.domain.ExerciseFact;

import java.util.Collection;

public interface ExerciseFactRepository extends CrudRepository<ExerciseFact, Long> {

    @Query(
            value = "INSERT INTO EXERCISE_FACT (user_id, exercise_id, score) VALUES (:userId, :exerciseId, :score)",
            nativeQuery = true)
    void insertNewExerciseFactUserIdExerciseIdScore(@Param("userId") Long userId,
                                                    @Param("exerciseId") Long exerciseId,
                                                    @Param("score") Long score);
}
