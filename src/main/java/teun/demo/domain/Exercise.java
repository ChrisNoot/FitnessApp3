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
    private Long id;

    private String name;
    private String score;
    private Category category;
    private SubCategory subCategory;
    private MeasuringUnit measuringUnit;

    @OneToMany
    private Set<ExerciseFact> ExerciseFacts= new HashSet();

    public enum Category {
        CARDIO,GYMNASTIC,STRENGTH,WORKOUT
    }

    public enum SubCategory {
        SQUAT,DEADLIFT,ROWSTRENGTH,PUSH,CARRY,LUNGE,OLYMPICLIFT,
        JUMPINGROPE,PISTOLS,BOXJUMP,TGU,MUSCLEUP,TOESTOBAR,HANDSTAND,
        ROWCARDIO,BURPEE,
        CINDY,MURPH
    }

    public Exercise(Long id, String name, String score, Category category, SubCategory subCategory) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.category = category;
        this.subCategory = subCategory;
    }

    public enum MeasuringUnit {
        KG,REPEATS,METER,TIME,CAL
    }

}

