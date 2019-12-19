package teun.demo.domain;

import lombok.Data;

import java.util.List;

@Data
public class Group {
    private List<User> listOfUsers;
}
