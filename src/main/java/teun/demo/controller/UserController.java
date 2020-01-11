package teun.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import teun.demo.domain.Group;
import teun.demo.domain.User;
import teun.demo.repository.ExerciseRepository;
import teun.demo.repository.GroupRepository;
import teun.demo.repository.UserRepository;

import javax.validation.Valid;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/user")
@SessionAttribute("categories")
@SessionAttribute("subcategories")
public class UserController {


    private UserRepository userRepository;
    private GroupRepository groupRepository;
    private ExerciseRepository exerciseRepository;

    @Autowired
    public UserController(UserRepository userRepository, GroupRepository groupRepository, ExerciseRepository exerciseRepo) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.exerciseRepository = exerciseRepo;
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
        return "home";
    }

    @GetMapping("/test")
    public String showGroupByUserId() {
        Collection<Long> groupIds = groupRepository.findAllGroupsForUserIdNative(1L);
        log.info(groupIds.toString());
        return "userForm";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable long id) {

        log.info( Long.toString(id));
        return "showUserById";
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

    @ModelAttribute(name = "categories")
    public Set<String> showCategories() {
        Set<String> categories = new HashSet<>();
        this.exerciseRepository.findAll().forEach(x->categories.add(x.getCategory().toString()));
        return categories;
    }

    @ModelAttribute(name = "subCategories")
    public List<String> showSubCategories() {
        return null;
    }

}
