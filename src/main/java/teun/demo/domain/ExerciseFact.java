package teun.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor(access =  AccessLevel.PUBLIC,force = true)
@Entity
public class ExerciseFact {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Exercise exercise;

    @PrePersist
    public void createDate() {
        this.date = new Date();
    }
}
