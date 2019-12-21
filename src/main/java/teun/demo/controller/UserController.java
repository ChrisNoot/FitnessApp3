package teun.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import teun.demo.domain.User;
import teun.demo.repository.UserRepository;

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
    public String processNewUser(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/user/new";
    }

    @ModelAttribute(name = "user")
    public User newUser() {
        return new User();
    }
}
