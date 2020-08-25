package teun.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teun.demo.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
