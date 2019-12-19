package teun.demo.domain;

import lombok.Data;

import java.util.List;

@Data
public class Category {

    private List<Exercise> listOfExercises;


}