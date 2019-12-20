package teun.demo.repository;

import org.springframework.data.repository.CrudRepository;
import teun.demo.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {


}
