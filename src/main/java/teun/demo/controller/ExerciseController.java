package teun.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import teun.demo.domain.User;
import teun.demo.repository.ExerciseFactRepository;
import teun.demo.repository.ExerciseRepository;
import teun.demo.repository.UserRepository;

@Controller

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

    @ModelAttribute("selectedUser")
    public User newSelectedUser() {
        return new User();
    }

    public void printModelContent(Map model) {
        log.info("OBJECTS IN MODEL:");
        for (Object modelObject : model.keySet()) {
            log.info(modelObject + " " + model.get(modelObject));
        }
        log.info("EINDE");
    }

}
