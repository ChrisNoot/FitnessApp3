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
import java.util.Map;

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
            log.info(modelObject + " "+ model.get(modelObject));
        }
        log.info("EINDE");
    }

}
