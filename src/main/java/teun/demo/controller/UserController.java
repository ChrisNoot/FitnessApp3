package teun.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import teun.demo.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/showall")
    public String showAllUsers() {
        return "showall";
    }

    @GetMapping("/new")
    public String createNewUser() {
        return "userForm";
    }

    @ModelAttribute(name = "user")
    public User newUser() {
        return new User();
    }
}
