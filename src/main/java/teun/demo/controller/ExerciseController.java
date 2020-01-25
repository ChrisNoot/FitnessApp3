package teun.demo.controller;

import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import teun.demo.domain.Exercise;
import teun.demo.domain.ExerciseFact;
import teun.demo.domain.User;
import teun.demo.repository.ExerciseFactRepository;
import teun.demo.repository.ExerciseRepository;
import teun.demo.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/exercise")
@Slf4j
@SessionAttributes("selectedUser")
public class ExerciseController {

    private ExerciseFactRepository exerciseFactRepository;
    private ExerciseRepository exerciseRepository;
    private UserRepository userRepository;

    @Autowired
    public ExerciseController(ExerciseFactRepository exerciseFactRepo,
                              ExerciseRepository exerciseRepo,
                              UserRepository userRepo) {
        this.exerciseFactRepository = exerciseFactRepo;
        this.exerciseRepository = exerciseRepo;
        this.userRepository = userRepo;
    }

    @GetMapping("/{exerciseId}/{userId}")
    public String exerciseFormInput(@PathVariable Long userId, @PathVariable Long exerciseId, Model model){
        log.info("id of exercise: " +userId);
        User selectedUser = this.userRepository.findById(userId).get();
        Exercise exercise = this.exerciseRepository.findById(exerciseId).get();
        Log.info("gekozen exercise: " + exercise.toString());
        model.addAttribute("selectedUser",selectedUser);
        model.addAttribute("exercise",exercise);
        return "exerciseForm";
    }

    @PostMapping("/newFact")
    public String ProcessNewFact(@ModelAttribute ExerciseFact exerciseFact,
                                 @ModelAttribute User selectedUser) {

        exerciseFact.setUser(selectedUser);
        log.info(exerciseFact.toString());
        this.exerciseFactRepository.save(exerciseFact);
        return "redirect:/{exerciseId}/{userId}";
    }

    @ModelAttribute("selectedUser")
    public User selectedUser() {
        return new User();
    }

    @ModelAttribute("exerciseFact")
    public ExerciseFact newExerciseFact() {
        return new ExerciseFact();
    }



}
