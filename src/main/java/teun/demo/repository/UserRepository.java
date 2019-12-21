package teun.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teun.demo.domain.User;


public interface UserRepository extends CrudRepository<User,Long> {

}
