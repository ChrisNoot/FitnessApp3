package teun.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import teun.demo.domain.Group;
import teun.demo.domain.User;

import java.util.Collection;
import java.util.List;

public interface GroupRepository extends CrudRepository<Group,Long> {

    @Query(
            value = "SELECT groups_id FROM USER_TABLE ut left join user_table_groups utg on ut.id = utg.users_id",
            nativeQuery = true)
    Collection<Long> findAllGroupsForUserIdNative();
}
