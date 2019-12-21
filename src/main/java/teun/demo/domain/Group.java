package teun.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


@Data
public class Group {

    private String id;

    private List<User> listOfUsers;
}
