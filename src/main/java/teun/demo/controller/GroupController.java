package teun.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import teun.demo.domain.Group;
import teun.demo.domain.Group.Day;
import teun.demo.domain.User;
import teun.demo.repository.GroupRepository;
import teun.demo.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/groups")
public class GroupController {

    private GroupRepository groupRepository;
    private UserRepository userRepository;

    @Autowired
    public GroupController(GroupRepository groupRepo, UserRepository userRepo) {
        this.groupRepository = groupRepo;
        this.userRepository = userRepo;
    }

    @GetMapping("/show")
    public String showGroups(Model model) {
        log.info("groups/show");
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
        printModelContent(model.asMap());
        return "showGroups";
    }

    @GetMapping("/all")
    public String showAllGroups(Model model) {
        log.info("groups/all");
        printModelContent(model.asMap());
        model.addAttribute("colSpanLength", calculateMaxGroup());
        return "showAllGroups";
    }

    @GetMapping("/{id}")
    public String showUsersByGroupId(@PathVariable("id") Long id,Model model) {
        log.info("groups/{id}");
        List<User> users = new ArrayList<>();
        Collection<Long> userIds = groupRepository.findAllUsersForGroupIdNative(id);
        log.info(userIds.toString());
        userRepository.findAllById(userIds).forEach(x -> users.add(x));
        model.addAttribute("users",users);
        printModelContent(model.asMap());
        return "showUsersByGroupId";
    }

    @ModelAttribute(name = "allGroups")
    public List<Group> showGroups() {
        log.info("created allGroups");
        List<Group> groups = new ArrayList<>();
        this.groupRepository.findAll().forEach(e -> groups.add(e));
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
