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
    private String category;
    private String subCategory;
    private String measuringUnit;

    @OneToMany
    private Set<ExerciseFact> ExerciseFacts= new HashSet();

    public enum Category {
        CARDIO,SKILL,STRENGTH,WORKOUT
    }

    Category test1 = Category.SKILL;

    public enum SubCategory {
        SQUAT,DEADLIFT,ROWSTRENGTH,PUSH,CARRY,LUNGE,OLYMPICLIFT,
        JUMPINGROPE,PISTOLS,BOXJUMP,TGU,MUSCLEUP,TOESTOBAR,HANDSTAND,
        ROWCARDIO,SKI,AB,BURPEE,
        CINDY,MURPH
    }

    public Exercise(Long id, String name, Category category, SubCategory subCategory, MeasuringUnit mu) {
        this.id = id;
        this.name = name;
        this.category = category.toString().toLowerCase();
        this.subCategory = subCategory.toString().toLowerCase();
        this.measuringUnit = mu.toString().toLowerCase();
    }

    public enum MeasuringUnit {
        KG,REPEATS,METER,TIME,CAL,CM
    }

}

