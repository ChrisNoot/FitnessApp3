package teun.demo.domain;

import lombok.Data;

import javax.persistence.Id;
import java.util.List;

@Data
public class Category {


    @Id
    private String id;

    private List<Exercise> listOfExercises;


}