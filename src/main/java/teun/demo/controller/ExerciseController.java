package teun.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import teun.demo.domain.Exercise;
import teun.demo.repository.ExerciseFactRepository;
import teun.demo.repository.ExerciseRepository;

@Controller
@RequestMapping("/Categories")
@SessionAttributes("chosenCategory")
public class ExerciseController {

    private ExerciseFactRepository exerciseFactRepository;
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseController(ExerciseFactRepository exerciseFactRepo) {
        this.exerciseFactRepository = exerciseFactRepo;
    }

    public String showSubCategories(@ModelAttribute()) {
    }

    public void processCategory()

    @ModelAttribute(name = "chosenCategory")
    public Exercise.Category returnCategory() {

        return Exercise.Category.STRENGTH;
    }
}
