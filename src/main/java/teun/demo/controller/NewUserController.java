package teun.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import teun.demo.domain.User;
import teun.demo.repository.UserRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/user")


public class NewUserController {


    private UserRepository userRepository;

    @Autowired
    public NewUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/new")
    public String createNewUser() {

        return "userForm";
    }

    @GetMapping("/all")
    public String showAllUsers() {
        return "showAllUsers";
    }

    @PostMapping("/new")
    public String processNewUser(@ModelAttribute @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "userForm";
        }
        log.info(user.getCrowds().toString());
        userRepository.save(user);
        return "home";
    }

    @ModelAttribute(name = "user")
    public User newUser() {
        log.info("created user");
        return new User();
    }

    @ModelAttribute(name = "users")
    public List<User> showUser() {
        log.info("created allUsers");
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);
        return users;
    }

    public void printModelContent(Map model) {
        log.info("OBJECTS IN MODEL:");
        for (Object modelObject : model.keySet()) {
            log.info(modelObject + " "+ model.get(modelObject));
        }
        log.info("EINDE");
    }

}
