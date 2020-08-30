package teun.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import teun.demo.domain.User;
import teun.demo.repository.ExerciseFactRepository;
import teun.demo.repository.ExerciseRepository;
import teun.demo.repository.UserRepository;

import java.util.Map;

@Controller

@Slf4j
@SessionAttributes("selectedUser")
public class ExerciseController {

    private final ExerciseFactRepository exerciseFactRepository;
    private final ExerciseRepository exerciseRepository;
    private final UserRepository userRepository;

    public ExerciseController(
            @Autowired ExerciseFactRepository exerciseFactRepository
            , @Autowired ExerciseRepository exerciseRepository
            , @Autowired UserRepository userRepository) {
        this.exerciseFactRepository = exerciseFactRepository;
        this.exerciseRepository = exerciseRepository;
        this.userRepository = userRepository;
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
