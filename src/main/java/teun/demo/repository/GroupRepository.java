package teun.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import teun.demo.domain.Group;

public interface GroupRepository extends CrudRepository<Group,Long> {


}
