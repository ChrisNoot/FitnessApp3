package teun.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import teun.demo.repository.ExerciseFactRepository;
import teun.demo.repository.ExerciseRepository;

@Controller
public class ExerciseFactController {

    private ExerciseFactRepository exerciseFactRepository;
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseFactController(ExerciseFactRepository exerciseFactRepo, ExerciseRepository exerciseRepo) {
        this.exerciseFactRepository = exerciseFactRepo;
        this.exerciseRepository = exerciseRepo;
    }


}
