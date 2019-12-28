package teun.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import teun.demo.domain.Group;
import teun.demo.domain.User;
import teun.demo.repository.GroupRepository;
import teun.demo.repository.UserRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {


    private UserRepository userRepository;
    private GroupRepository groupRepository;

    @Autowired
    public UserController(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
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
        log.info(user.getGroups().toString());
        userRepository.save(user);
        return "userCreated";
    }

    @ModelAttribute(name = "user")
    public User newUser() {
        return new User();
    }


    @ModelAttribute(name = "allGroups")
    public List<Group> showGroups() {
        List<Group> groups = new ArrayList<>();
        this.groupRepository.findAll().forEach(e -> groups.add(e));
        return groups;
    }

    @ModelAttribute(name = "allUsers")
    public List<User> showUser() {
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);
        return users;
    }

}
