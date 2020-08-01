package teun.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import teun.demo.domain.ExerciseFact;

public interface ExerciseFactRepository extends CrudRepository<ExerciseFact, Long> {

    @Query(
            value = "INSERT INTO EXERCISE_FACT_TABLE values (user_id = :userId, exercise_id = :exerciseId, score = :score",
            nativeQuery = true)
    void insertNewExerciseFactUserIdExerciseIdScore(@Param("userId") Long userId,
                                                    @Param("exerciseId") Long exerciseId,
                                                    @Param("score") Long score);

}
