package teun.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import teun.demo.domain.Crowd;
import teun.demo.domain.Crowd.Day;
import teun.demo.domain.User;
import teun.demo.repository.CrowdRepository;
import teun.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/crowds")
public class CrowdController {

    private CrowdRepository crowdRepository;
    private UserRepository userRepository;

    @Autowired
    public CrowdController(CrowdRepository groupRepo, UserRepository userRepo) {
        this.crowdRepository = groupRepo;
        this.userRepository = userRepo;
    }

    @GetMapping("/show")
    public String showGroups(Model model) {
        log.info("crowds/show");
        List<Crowd> crowds = new ArrayList<>();
        this.crowdRepository.findAll().forEach(crowds::add);


        log.info(crowds.toString());
        Day[] days = Day.values();
        for (Day day : days) {
            model.addAttribute(day.toString().toLowerCase(),
                    crowds.stream()
                            .filter(x -> x.getDay().equals(day))
                            .collect(Collectors.toList()));
        }
        printModelContent(model.asMap());
        return "showCrowds";
    }

    @GetMapping("/all")
    public String showAllGroups(Model model) {
        log.info("crowds/all");
        printModelContent(model.asMap());
        return "showAllGroups";
    }

    @GetMapping("/new")
    public String createGroup() {
        return "createCrowd";
    }


    @GetMapping("/{id}")
    public String showUsersByGroupId(@PathVariable("id") Long id, Model model) {
        log.info("crowds/{id}");
        List<User> users = new ArrayList<>();
        Collection<Long> userIds = crowdRepository.findAllUsersForCrowdIdNative(id);
        log.info(userIds.toString());
        userRepository.findAllById(userIds).forEach(x -> users.add(x));
        model.addAttribute("users", users);
        printModelContent(model.asMap());
        return "showUsersByCrowdId";
    }

    @ModelAttribute(name = "allCrowds")
    public List<Crowd> showGroups() {
        log.info("created allCrowds");
        List<Crowd> crowds = new ArrayList<>();
        this.crowdRepository.findAll().forEach(e -> crowds.add(e));
        return crowds;
    }

    public void printModelContent(Map model) {
        log.info("OBJECTS IN MODEL:");
        for (Object modelObject : model.keySet()) {
            log.info(modelObject + " " + model.get(modelObject));
        }
        log.info("EINDE");
    }


}
