package teun.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import teun.demo.domain.Group;
import teun.demo.domain.User;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group,Long> {


}
