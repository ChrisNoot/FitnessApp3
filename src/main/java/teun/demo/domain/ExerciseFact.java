package teun.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Data
@NoArgsConstructor(access =  AccessLevel.PUBLIC,force = true)
@Entity
public class ExerciseFact {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date date;
    private String score;

    @ManyToOne
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private Exercise exercise;

    @PrePersist
    public void createDate() {
        this.date = new Date();
    }

}
