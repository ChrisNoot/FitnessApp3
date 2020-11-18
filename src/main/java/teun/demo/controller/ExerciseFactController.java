package teun.demo.controller;

import javafx.scene.chart.Chart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import teun.demo.domain.Exercise;
import teun.demo.domain.ExerciseFact;
import teun.demo.domain.User;
import teun.demo.repository.ExerciseFactRepository;
import teun.demo.repository.ExerciseRepository;
import teun.demo.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Slf4j
@SessionAttributes({"selectedUser", "selectedCategory", "selectedSubCategory", "selectedExercise"})
@Controller
@RequestMapping("/exercise")
public class ExerciseFactController {

    private ExerciseFactRepository exerciseFactRepository;
    private ExerciseRepository exerciseRepository;
    private UserRepository userRepository;

    @Autowired
    public ExerciseFactController(ExerciseFactRepository exerciseFactRepo,
                                  ExerciseRepository exerciseRepo,
                                  UserRepository userRepo) {
        this.exerciseFactRepository = exerciseFactRepo;
        this.exerciseRepository = exerciseRepo;
        this.userRepository = userRepo;
    }

    @GetMapping("/{id}/categories")
    public String showCat(@PathVariable long id, Model model) {
        log.info("/{id}/categories");
        log.info("changed selectedUser to " + this.userRepository.findById(id).get().toString());
        model.addAttribute("selectedUser", this.userRepository.findById(id).get());
        printModelContent(model.asMap());
        return "showCategories";
    }

    @GetMapping("/{id}/{category}")
    public String showSubcat(@PathVariable long id,
                             @PathVariable String category,
                             Model model) {
        log.info("/{id}/{category}");
        log.info(category);
        Collection<String> subCategories = this.exerciseRepository.findSubCategoriesByCategory(category);
        log.info(subCategories.toString());
        model.addAttribute("subCategories", subCategories);
        log.info("changed subCategories to PathVariable");
        printModelContent(model.asMap());
        return "showSubcategories";
    }

    @GetMapping("/{id}/{category}/{subCat}")
    public String showExercise1(@PathVariable long id,
                                @PathVariable String category,
                                @PathVariable String subCat,
                                Model model) {
        log.info("/{id}/{category}/{subCat}");
        log.info("dit is je geselecteerde category: " + category);
        log.info("dit is je geselecteerde subcat: " + subCat);
        List<Exercise> exercises = this.exerciseRepository.findExercisesBySubCategory(subCat);
        log.info("dit zijn je exercises: " + exercises.toString());
        model.addAttribute("category", category);
        model.addAttribute("exercises", exercises);
        log.info("changed category to PathVariable");
        log.info("changed exercises to PathVariable");
        printModelContent(model.asMap());
        System.out.println("hello");
        return "showExercises";
    }

    @GetMapping("/{exerciseId}")
    public String exerciseFormInput(@PathVariable long exerciseId, Model model) {
        log.info("/{exerciseId}/{userId}");
        Exercise exercise = this.exerciseRepository.findById(exerciseId).get();
        log.info("gekozen exercise: " + exercise.toString() + " met id: " + exercise.getId());
        model.addAttribute("selectedExercise", exercise);
        printModelContent(model.asMap());
        return "exerciseForm";
    }

    class ChartEntry {

        public Long getScore() {
            return score;
        }

        public String getDate() {
            return date;
        }

        Long score;
        String date;

        public ChartEntry(Long score, LocalDateTime dateTime) {
            this.score = score;
            this.date = dateTime.format(DateTimeFormatter.ISO_DATE);
        }


    }

    @PostMapping("/newFact")
    public String ProcessNewFact(@ModelAttribute ExerciseFact exerciseFact, Model model) {
        log.info("/newFact");
        log.info("class van exerciseFact is " + exerciseFact.getClass());
        User selectedUser = (User) model.getAttribute("selectedUser");
        Exercise selectedExercise = (Exercise) model.getAttribute("selectedExercise");
        exerciseFact.setUser(selectedUser);
        exerciseFact.setExercise(selectedExercise);
        exerciseFactRepository.save(exerciseFact);
        printModelContent(model.asMap());

        List<ExerciseFact> exerciseFacts = exerciseFactRepository.findExerciseFactByUserIdAndExerciseId(selectedUser.getId(), selectedExercise.getId());
        model.addAttribute("exerciseFacts", exerciseFacts.stream().map(x -> new ChartEntry(x.getScore(), x.getDate())).collect(Collectors.toList()));
        return "exerciseForm";
    }

    // ModelAttributes
    @ModelAttribute(name = "exercise")
    public Exercise findExercise() {
        return new Exercise();
    }


    @ModelAttribute(name = "categories")
    public Set<String> showCategories() {
        log.info("Put categories in Model");
        Set<String> categories = new HashSet<>();
        this.exerciseRepository.findAll().forEach(x -> categories.add(x.getCategory().toLowerCase()));
        return categories;
    }

    @ModelAttribute("selectedUser")
    public User findSelectedUser() {
        log.info("created new object selectedUser");
        return new User();
    }

    @ModelAttribute("selectedExercise")
    public Exercise findSelectedExercise() {
        log.info("created new object selectedUser");
        return new Exercise();
    }

    @ModelAttribute("exerciseFacts")
    public List<ExerciseFact> newExerciseFacts() {
        return new ArrayList<>();
    }

    @ModelAttribute("exerciseFact")
    public ExerciseFact newExerciseFact() {
        return new ExerciseFact();
    }

    public void printModelContent(Map model) {
        log.info("OBJECTS IN MODEL:");
        for (Object modelObject : model.keySet()) {
            log.info(modelObject + " " + model.get(modelObject));
        }
        log.info("EINDE");
    }


}
