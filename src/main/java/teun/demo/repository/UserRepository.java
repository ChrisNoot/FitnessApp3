package teun.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import teun.demo.domain.Group;
import teun.demo.domain.User;

import javax.persistence.TypedQuery;
import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {


}
