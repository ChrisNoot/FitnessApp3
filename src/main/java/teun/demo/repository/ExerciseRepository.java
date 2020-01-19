package teun.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import teun.demo.domain.Exercise;

import java.util.Collection;
import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    @Query(
            value = "SELECT distinct sub_category FROM EXERCISE where category = :category",
            nativeQuery = true)
    Collection<String> findSubCategoriesByCategory(@Param("category") String category);

}
