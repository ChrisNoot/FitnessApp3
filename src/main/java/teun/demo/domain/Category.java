package teun.demo.domain;

import lombok.Data;

import javax.persistence.Id;
import java.util.List;

@Data
public class Category {


    private String id;

    private List<Exercise> listOfExercises;


}