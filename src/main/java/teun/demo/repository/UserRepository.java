package teun.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import teun.demo.domain.Group;
import teun.demo.domain.User;

import javax.persistence.TypedQuery;
import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    public User getUserByIdWithTypedQuery(Long id) {
        TypedQuery<User> typedQuery
                = getEntityManager().createQuery("SELECT u FROM UserEntity u WHERE u.id=:id", User.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

}
