package teun.demo.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import teun.demo.domain.ExerciseFact;
import teun.demo.domain.User;
import teun.demo.repository.ExerciseFactRepository;
import teun.demo.repository.UserRepository;

import static java.util.stream.Collectors.toList;

@Slf4j
@Controller
@RequestMapping
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ExerciseFactRepository exerciseFactRepository;

    @GetMapping
    public String showHome() {
        return "home";
    }

    @ModelAttribute(name = "recentChangedUsers")
    public List<User> showUser() {
        List<ExerciseFact> exerciseFacts = new ArrayList<>();
        log.info("created allUsers");
        exerciseFactRepository.findAll().forEach(fact -> exerciseFacts.add(fact));
        List<User> recentChangedUsers = StreamEx.of(exerciseFacts)
            .sorted(Comparator.comparing(ExerciseFact::getDate).reversed())
            .distinct(ExerciseFact::getUser)
            .limit(8)
            .map(fact -> fact.getUser())
            .collect(toList());
        return recentChangedUsers;
    }
}
