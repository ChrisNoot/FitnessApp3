package teun.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor(access =  AccessLevel.PUBLIC,force = true)
@Entity
public class Exercise {

    @Id
    private String id;

    private String name;
    private String score;

    @OneToMany
    private Set<ExerciseFact> ExerciseFacts= new HashSet();

    public enum Category {
        CARDIO,GYMNASTIC,STRENGTH,WORKOUT
    }

    public enum SubCategory {
        SUB1,SUB2,SUB3,SUB4
    }

}

