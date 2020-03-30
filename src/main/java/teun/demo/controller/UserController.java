package teun.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import teun.demo.domain.Exercise;
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
@SessionAttributes({"selectedUser", "selectedCategory","selectedSubCategory"})

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


    @GetMapping("/{id}/categories")
    public String showCat(@PathVariable long id,Model model) {
        log.info("/{id}/categories");
        log.info("changed selectedUser to PathVariable");
        model.addAttribute("selectedUser",this.userRepository.findById(id).get());
        printModelContent(model.asMap());
        return "showCategories";
    }

    @ModelAttribute(name = "user")
    public User newUser() {
        log.info("created user");
        return new User();
    }

    @ModelAttribute(name = "allUsers")
    public List<User> showUser() {
        log.info("created allUsers");
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);
        return users;
    }

    @ModelAttribute(name = "categories")
    public Set<String> showCategories() {
        log.info("created empty Categories");
        Set<String> categories = new HashSet<>();
        this.exerciseRepository.findAll().forEach(x->categories.add(x.getCategory().toString().toLowerCase()));
        return categories;
    }

    @ModelAttribute(name = "subCategories")
    public Set<String> showSubCategories() {
        log.info("created empty subCategories");
        Set<String> subCategories = new HashSet<>();
        return subCategories;
    }

    @ModelAttribute("selectedUser")
    public User findSelectedUser() {
        log.info("created empty selectedUser");
        return new User();
    }

    @ModelAttribute("selectedCategory")
    public String findSelectedCategory() {
        log.info("created selectedCategory");
        return null;
    }

    @ModelAttribute("selectedSubCategory")
    public String findSelectedSubCategory() {
        log.info("created selectedSubCategory");
        return null;
    }

    public void printModelContent(Map model) {
        log.info("Objects in model:");
        for (Object modelObject : model.keySet()) {
            log.info(modelObject + " "+ model.get(modelObject));
        }
        log.info("EINDE");
    }

}
