package teun.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import teun.demo.domain.Group;

import java.util.Collection;
import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Long> {

    @Query(
            value = "SELECT groups_id FROM USER_TABLE_GROUPS where users_id = :userId",
            nativeQuery = true)
    Collection<Long> findAllGroupsForUserIdNative(@Param("userId") Long userId);

    @Query(
            value = "SELECT users_id FROM USER_TABLE_GROUPS where groups_id = :groupId",
            nativeQuery = true)
    Collection<Long> findAllUsersForGroupIdNative(@Param("groupId") Long groupId);

    List<Group> findAll();
}
