package teun.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;

@NoArgsConstructor(access =  AccessLevel.PUBLIC,force = true)
@Entity
@Data
@Table(name = "groupTable")
public class Group {

    @Id
    private Long id;

    private Date createdAt;
    private String hourTime;
    private Day day;
    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    @ManyToMany
    private List<User> listOfUsers;

    @PrePersist
    public void createdAt() {
        this.createdAt = new Date();
    }

}
