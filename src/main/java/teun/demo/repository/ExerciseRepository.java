package teun.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teun.demo.domain.Exercise;

import java.util.Collection;
import java.util.List;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    @Query(
            value = "SELECT distinct subCategory FROM Exercise where category = :category",
            nativeQuery = true)
    Collection<String> findSubCategoriesByCategory(@Param("category") String category);

    @Query(
            value = "SELECT * FROM Exercise where subCategory = :subCategory",
            nativeQuery = true)
    List<Exercise> findExercisesBySubCategory(@Param("subCategory") String subCategory);

}
