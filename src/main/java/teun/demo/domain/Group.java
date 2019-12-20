package teun.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Group {

    @Id
    private String id;

    private List<User> listOfUsers;
}
