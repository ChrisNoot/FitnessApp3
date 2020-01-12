package teun.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import teun.demo.domain.Exercise;
import teun.demo.repository.ExerciseFactRepository;
import teun.demo.repository.ExerciseRepository;

@Controller
@RequestMapping("/Categories")
public class ExerciseController {

    private ExerciseFactRepository exerciseFactRepository;
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseController(ExerciseFactRepository exerciseFactRepo) {
        this.exerciseFactRepository = exerciseFactRepo;
    }

    @ModelAttribute(name = "chosenCategory")
    public Exercise.Category returnCategory() {

        return Exercise.Category.STRENGTH;
    }
}
