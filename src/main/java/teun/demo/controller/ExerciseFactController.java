package teun.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import teun.demo.domain.Exercise;
import teun.demo.domain.ExerciseFact;
import teun.demo.domain.User;
import teun.demo.repository.ExerciseFactRepository;
import teun.demo.repository.ExerciseRepository;
import teun.demo.repository.UserRepository;

import java.util.*;

@Slf4j
@SessionAttributes({"selectedUser", "selectedCategory","selectedSubCategory"})
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
    public String showCat(@PathVariable long id,Model model) {
        log.info("/{id}/categories");
        log.info("changed selectedUser to PathVariable");
        model.addAttribute("selectedUser",this.userRepository.findById(id).get());
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
        model.addAttribute("subCategories",subCategories);
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
        log.info("dit is je geselecteerde category: "+category);
        log.info("dit is je geselecteerde subcat: "+subCat);
        List<Exercise> exercises = this.exerciseRepository.findExercisesBySubCategory(subCat);
        log.info("dit zijn je exercises: "+exercises.toString());
        model.addAttribute("category",category);
        model.addAttribute("exercises",exercises);
        log.info("changed category to PathVariable");
        log.info("changed exercises to PathVariable");
        printModelContent(model.asMap());
        return "showExercises";
    }

    @GetMapping("/{exerciseId}")
    public String exerciseFormInput( @PathVariable Long exerciseId, Model model){
        log.info("/{exerciseId}/{userId}");
        //log.info("id of user " +userId);
        //User selectedUser = this.userRepository.findById(userId).get();
        Exercise exercise = this.exerciseRepository.findById(exerciseId).get();
        log.info("gekozen exercise: " + exercise.toString()+" met id: " + exercise.getId());
        //model.addAttribute("selectedUser",selectedUser);
        model.addAttribute("exercise",exercise);
        printModelContent(model.asMap());
        return "exerciseForm";
    }

    @PostMapping("/newFact")
    public String ProcessNewFact(@ModelAttribute ExerciseFact exerciseFact,
                                 @ModelAttribute User selectedUser, Model model) {
        // deze user wordt niet goed geset. Kan blijkbaar niet op basis van transient dingen?
        // waarom wordt date ook niet goed gebruikt?
        // exercise gaat ook niet naar het goede
        // en waarom is de id nog niet gegenerate?
        log.info("/newFact");
        exerciseFact.setUser(selectedUser);
        printModelContent(model.asMap());
        log.info(exerciseFact.toString());
        this.exerciseFactRepository.save(exerciseFact);
        return "redirect:/{exerciseId}/{userId}";
    }

    // ModelAttributes
    @ModelAttribute(name = "categories")
    public Set<String> showCategories() {
        log.info("Put categories in Model");
        Set<String> categories = new HashSet<>();
        this.exerciseRepository.findAll().forEach(x->categories.add(x.getCategory().toString().toLowerCase()));
        return categories;
    }

    @ModelAttribute("selectedUser")
    public User findSelectedUser() {
        log.info("created new object selectedUser");
        return new User();
    }

    @ModelAttribute("exerciseFact")
    public ExerciseFact newExerciseFact() {
        return new ExerciseFact();
    }

    public void printModelContent(Map model) {
        log.info("OBJECTS IN MODEL:");
        for (Object modelObject : model.keySet()) {
            log.info(modelObject + " "+ model.get(modelObject));
        }
        log.info("EINDE");
    }


}
