package teun.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teun.demo.domain.Crowd;

import java.util.Collection;

@Repository
public interface CrowdRepository extends CrudRepository<Crowd, Long> {

    @Query(
            value = "SELECT id FROM crowd where user_table_id = :userId",
            nativeQuery = true)
    Collection<Long> findAllCrowdsForUserIdNative(@Param("userId") Long userId);

    @Query(
            value = "SELECT USERS_ID FROM crowd_user_table where crowd_id = :crowdId",
            nativeQuery = true)
    Collection<Long> findAllUsersForCrowdIdNative(@Param("crowdId") Long crowdId);
}
