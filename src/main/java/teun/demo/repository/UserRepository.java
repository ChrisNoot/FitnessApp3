package teun.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import teun.demo.domain.Group;
import teun.demo.domain.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    public UserEntity getUserByIdWithTypedQuery(Long id) {
        TypedQuery<UserEntity> typedQuery
                = getEntityManager().createQuery("SELECT u FROM UserEntity u WHERE u.id=:id", UserEntity.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

}
