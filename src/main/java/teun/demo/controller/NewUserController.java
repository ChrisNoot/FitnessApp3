package teun.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/user")
public class NewUserController {


    private UserRepository userRepository;
    private GroupRepository groupRepository;

    @Autowired
    public NewUserController(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository= groupRepository;
    }


    @GetMapping("/new")
    public String createNewUser(Model model) {
        model.addAttribute("colSpanLength", calculateMaxGroup());
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

    @ModelAttribute(name = "allGroups")
    public List<Group> showGroups() {
        log.info("created allGroups");
        List<Group> groups = new ArrayList<>();
        this.groupRepository.findAll().forEach(groups::add);
        return groups;
    }

    public void printModelContent(Map model) {
        log.info("OBJECTS IN MODEL:");
        for (Object modelObject : model.keySet()) {
            log.info(modelObject + " "+ model.get(modelObject));
        }
        log.info("EINDE");
    }

    private long calculateMaxGroup() {
        Map<String,Long> map = groupRepository.findAll().stream()
            .collect(Collectors.groupingBy(Group::getDay, Collectors.counting()));
        return map.values().stream().max(Comparator.naturalOrder()).orElse(3L);
    }

}
