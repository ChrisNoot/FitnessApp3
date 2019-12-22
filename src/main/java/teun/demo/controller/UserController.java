package teun.demo.controller;

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

@Controller
@RequestMapping("/user")
public class UserController {


    private UserRepository userRepo;

    @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/showall")
    public String showAllUsers() {
        return "showall";
    }

    @GetMapping("/new")
    public String createNewUser() {
        return "userForm";
    }

    @PostMapping("/new")
    public String processNewUser(@ModelAttribute @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "userForm";
        }

        userRepo.save(user);
        return "userCreated";
    }

    @ModelAttribute(name = "user")
    public User newUser() {
        return new User();
    }
}
