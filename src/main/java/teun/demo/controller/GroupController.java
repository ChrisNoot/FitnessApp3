package teun.demo.controller;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import teun.demo.domain.Group;
import teun.demo.domain.Group.Day;
import teun.demo.domain.User;
import teun.demo.repository.GroupRepository;
import teun.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/groups")
public class GroupController {

    private GroupRepository groupRepository;

    @Autowired
    public GroupController(GroupRepository groupRepo) {
        this.groupRepository = groupRepo;
    }

    @GetMapping("/show")
    public String showGroups(Model model) {

        List<Group> groups = new ArrayList<>();
        this.groupRepository.findAll().forEach(groups::add);


        log.info(groups.toString());
        Day[] days = Day.values();
        for (Day day : days) {
            model.addAttribute(day.toString().toLowerCase(),
                    groups.stream()
                            .filter(x -> x.getDay().equals(day))
                            .collect(Collectors.toList()));
        }
        log.info(model.asMap().toString());
        return "showGroups";
    }

    @GetMapping("/all")
    public String showAllGroups() {
        return "showAllGroups";
    }

    @GetMapping("/new")
    public String createGroup() {
        return "createGroup";
    }

    @GetMapping("/{id}")
    public List<User> showUsersByGroupId(@PathVariable("id") Long id) {
        List<Group> usersInGroup = new ArrayList<>();
        this.groupRepository.findById(id);
        return null;
    }

    @ModelAttribute(name = "allGroups")
    public List<Group> showGroups() {
        List<Group> groups = new ArrayList<>();
        this.groupRepository.findAll().forEach(e -> groups.add(e));
        return groups;
    }


}