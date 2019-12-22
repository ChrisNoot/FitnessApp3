package teun.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor(access =  AccessLevel.PUBLIC,force = true)
@Entity
@Data
@Table(name = "groupTable")
public class Group {

    @Id
    private String id;

    private Date createdAt;

    private Date time;
    @ManyToMany
    private List<User> listOfUsers;

    @PrePersist
    public void createdAt() {
        this.createdAt = new Date();
    }
}
