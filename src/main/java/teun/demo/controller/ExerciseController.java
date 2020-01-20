package teun.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import teun.demo.domain.Exercise;
import teun.demo.repository.ExerciseFactRepository;
import teun.demo.repository.ExerciseRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {

    private ExerciseFactRepository exerciseFactRepository;
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseController(ExerciseFactRepository exerciseFactRepo) {
        this.exerciseFactRepository = exerciseFactRepo;
    }

    public String exerciseInput(){
        return "exerciseForm";
    }



}
