package teun.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public class UserController {

    @GetMapping("/showall")
    public String showAllUsers() {
        return "showall";
    }

    @GetMapping("/new")
    public String createNewUser() {
        return "newUserForm";
    }
}
