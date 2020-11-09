package teun.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
@Table(name = "groupTable")
public class Group {

    @Id
    private Long id;
    private Date createdAt;
    private String hourTime;
    private String day;

    public Group(long l, String s, Date date, Day day) {
        this.id = l;
        this.createdAt = date;
        this.hourTime = s;
        this.day = day.toString().toLowerCase();
    }

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    @PrePersist
    public void createdAt() {
        this.createdAt = new Date();
    }

    public String toString() {
        return day.toLowerCase() + " " + hourTime;
    }

    @ManyToMany(mappedBy = "groups", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

}
