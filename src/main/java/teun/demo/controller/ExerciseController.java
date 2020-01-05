package teun.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import teun.demo.domain.Exercise;
import teun.demo.repository.ExerciseFactRepository;
import teun.demo.repository.ExerciseRepository;

@Controller
public class ExerciseController {

    private ExerciseFactRepository exerciseFactRepository;
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseController(ExerciseFactRepository exerciseFactRepo, ExerciseRepository exerciseRepo) {
        this.exerciseFactRepository = exerciseFactRepo;
        this.exerciseRepository = exerciseRepo;

    }
}
