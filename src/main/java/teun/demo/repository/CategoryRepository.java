package teun.demo.repository;

import org.springframework.data.repository.CrudRepository;
import teun.demo.domain.Category;

public interface CategoryRepository extends CrudRepository<Category,String> {
}
