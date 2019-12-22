package teun.demo.controller;


import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import teun.demo.domain.Group;
import teun.demo.domain.Group.Day;
import teun.demo.repository.GroupRepository;

import java.util.ArrayList;
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

    @GetMapping("/all")
    public String showGroups(Model model) {

        List<Group> groups = new ArrayList<>();
        this.groupRepository.findAll().forEach(groups::add);
        log.info(groups.toString());
        Group group1 = new Group();
        group1.setDay(Day.MONDAY);
        group1.setId(157L);
        group1.setHourTime("19:00");
        group1.setCreatedAt(new Date());
        groups.add(group1);
        Group group2 = new Group();
        group1.setDay(Day.TUESDAY);
        group1.setId(158L);
        group1.setHourTime("18:00");
        group1.setCreatedAt(new Date());
        groups.add(group2);
        Group group3 = new Group();
        group1.setDay(Day.TUESDAY);
        group1.setId(159L);
        group1.setHourTime("20:00");
        group1.setCreatedAt(new Date());
        groups.add(group3);

        Day[] days = Day.values();
        for (Day day : days) {
            model.addAttribute(day.toString().toLowerCase(),
                    groups.stream()
                            .filter(x -> x.getDay() == day)
                            .collect(Collectors.toList()));
        }

        return "showGroups";
    }
}
