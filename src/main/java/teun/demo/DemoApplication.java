package teun.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import teun.demo.domain.Crowd;
import teun.demo.domain.Exercise;
import teun.demo.domain.Exercise.Category;
import teun.demo.domain.Exercise.MeasuringUnit;
import teun.demo.domain.Exercise.SubCategory;
import teun.demo.domain.User;
import teun.demo.repository.CrowdRepository;
import teun.demo.repository.ExerciseRepository;
import teun.demo.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private CrowdRepository crowdRepository;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ExerciseRepository exerciseRepo;

    @Transactional
    @PostConstruct
    public void init() {
        Crowd crowd1 = new Crowd(1L,"19:00", new Date(), Crowd.Day.TUESDAY);
        Crowd crowd2 = new Crowd(2L, "20:00", new Date(), Crowd.Day.TUESDAY);
        crowdRepository.save(crowd1);
        crowdRepository.save(crowd2);
        crowdRepository.save(new Crowd(3L, "21:00", new Date(), Crowd.Day.TUESDAY));
        crowdRepository.save(new Crowd(4L, "18:00", new Date(), Crowd.Day.WEDNESDAY));
        crowdRepository.save(new Crowd(5L, "19:00", new Date(), Crowd.Day.WEDNESDAY));
        crowdRepository.save(new Crowd(6L, "19:00", new Date(), Crowd.Day.SATURDAY));
        crowdRepository.save(new Crowd(7L, "18:00", new Date(), Crowd.Day.SATURDAY));
        crowdRepository.save(new Crowd(8L, "21:00", new Date(), Crowd.Day.SUNDAY));
        List<Crowd> testCrowds = new ArrayList<>();
        testCrowds.add(crowd1);
        testCrowds.add(crowd2);
        User user = new User( 0L, new Date(), "teun", "teunajax", "70",
                "180", "15-05-1992", "chris.nooteboom@gmail.com", "0618571699", testCrowds);
        User savedUser = userRepo.save(user);

        exerciseRepo.save(new Exercise(1L, "Front Squat", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(2L, "Back Squat", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(3L, "Goblet Squat", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(4L, "OH Squat", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(5L, "Split Squat", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(6L, "Bulgarian Split Squat", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(7L, "Deadlift", Category.STRENGTH, SubCategory.DEADLIFT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(8L, "Kettlebell Deadlift", Category.STRENGTH, SubCategory.DEADLIFT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(9L, "Sumo Deadlift", Category.STRENGTH, SubCategory.DEADLIFT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(10L, "Single Leg Deadlift", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(11L, "Barbell Row", Category.STRENGTH, SubCategory.ROWSTRENGTH, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(12L, "Dumbbell Row", Category.STRENGTH, SubCategory.ROWSTRENGTH, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(13L, "Chin-up", Category.STRENGTH, SubCategory.ROWSTRENGTH, MeasuringUnit.REPEATS));
        exerciseRepo.save(new Exercise(14L, "Pull-up", Category.STRENGTH, SubCategory.ROWSTRENGTH, MeasuringUnit.REPEATS));
        exerciseRepo.save(new Exercise(15L, "Push-up", Category.STRENGTH, SubCategory.PUSH, MeasuringUnit.REPEATS));
        exerciseRepo.save(new Exercise(16L, "Bench Press", Category.STRENGTH, SubCategory.PUSH, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(17L, "Stricht Press", Category.STRENGTH, SubCategory.PUSH, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(18L, "Push Press", Category.STRENGTH, SubCategory.PUSH, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(19L, "Incline Bench Press", Category.STRENGTH, SubCategory.PUSH, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(20L, "Dumbbell Floor Press", Category.STRENGTH, SubCategory.PUSH, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(21L, "Farmers Walk", Category.STRENGTH, SubCategory.CARRY, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(22L, "Suitcase Walk", Category.STRENGTH, SubCategory.CARRY, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(23L, "Lunge", Category.STRENGTH, SubCategory.LUNGE, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(24L, "Power Clean", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(25L, "Hang Clean", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(26L, "Squat Clean", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(27L, "Push Jerk", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(28L, "Split Jerk", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(29L, "Snatch", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(30L, "Hang Snatch", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(31L, "Squat Snatch", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(32L, "Single Under", Category.SKILL, SubCategory.JUMPINGROPE, MeasuringUnit.REPEATS));
        exerciseRepo.save(new Exercise(33L, "Double Under", Category.SKILL, SubCategory.JUMPINGROPE, MeasuringUnit.REPEATS));
        exerciseRepo.save(new Exercise(34L, "Pistols", Category.SKILL, SubCategory.PISTOLS, MeasuringUnit.REPEATS));
        exerciseRepo.save(new Exercise(35L, "Box Jump", Category.SKILL, SubCategory.BOXJUMP, MeasuringUnit.CM));
        exerciseRepo.save(new Exercise(36L, "Left", Category.SKILL, SubCategory.TGU, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(37L, "Right", Category.SKILL, SubCategory.TGU, MeasuringUnit.KG));
        exerciseRepo.save(new Exercise(38L, "500m", Category.CARDIO, SubCategory.ROWCARDIO, MeasuringUnit.TIME));
        exerciseRepo.save(new Exercise(39L, "1000m", Category.CARDIO, SubCategory.ROWCARDIO, MeasuringUnit.TIME));
        exerciseRepo.save(new Exercise(40L, "2500m", Category.CARDIO, SubCategory.ROWCARDIO, MeasuringUnit.TIME));
        exerciseRepo.save(new Exercise(41L, "5km", Category.CARDIO, SubCategory.ROWCARDIO, MeasuringUnit.TIME));
        exerciseRepo.save(new Exercise(42L, "10km", Category.CARDIO, SubCategory.ROWCARDIO, MeasuringUnit.TIME));
        exerciseRepo.save(new Exercise(43L, "500m", Category.CARDIO, SubCategory.SKI, MeasuringUnit.TIME));
        exerciseRepo.save(new Exercise(44L, "1000m", Category.CARDIO, SubCategory.SKI, MeasuringUnit.TIME));
        exerciseRepo.save(new Exercise(45L, "1 min", Category.CARDIO, SubCategory.AB, MeasuringUnit.CAL));
        exerciseRepo.save(new Exercise(46L, "30 cal", Category.CARDIO, SubCategory.AB, MeasuringUnit.TIME));
        exerciseRepo.save(new Exercise(47L, "Cindy", Category.WORKOUT, SubCategory.CINDY, MeasuringUnit.REPEATS));
        exerciseRepo.save(new Exercise(48L, "100/200/300", Category.WORKOUT, SubCategory.MURPH, MeasuringUnit.TIME));
        exerciseRepo.save(new Exercise(49L, "5/10/15", Category.WORKOUT, SubCategory.MURPH, MeasuringUnit.TIME));
    }


//    @Bean
//    public CommandLineRunner dataLoader(CrowdRepository crowdRepository, UserRepository userRepo, ExerciseRepository exerciseRepo) {
//        return new CommandLineRunner() {
//
//            public void run(String... args) throws Exception {
//                Crowd crowd1 = new Crowd(1L,"19:00", new Date(), Crowd.Day.TUESDAY);
//                Crowd crowd2 = new Crowd(2L,"20:00", new Date(), Crowd.Day.TUESDAY);
//                crowdRepository.save(crowd1);
//                crowdRepository.save(crowd2);
//                crowdRepository.save(new Crowd(3L,"21:00", new Date(), Crowd.Day.TUESDAY));
//                crowdRepository.save(new Crowd(4L,"18:00", new Date(), Crowd.Day.WEDNESDAY));
//                crowdRepository.save(new Crowd(5L,"19:00", new Date(), Crowd.Day.WEDNESDAY));
//                crowdRepository.save(new Crowd(6L,"19:00", new Date(), Crowd.Day.SATURDAY));
//                crowdRepository.save(new Crowd(7L,"18:00", new Date(), Crowd.Day.SATURDAY));
//                crowdRepository.save(new Crowd(8L,"21:00", new Date(), Crowd.Day.SUNDAY));
//                List<Crowd> testCrowds = new ArrayList<>();
//                testCrowds.add(crowd1);
//                testCrowds.add(crowd2);
//                userRepo.save(new User(1L, new Date(), "teun", "teunajax", "70",
//                        "180", "15-05-1992", "chris.nooteboom@gmail.com", "0618571699", testCrowds)
//                );
//                exerciseRepo.save(new Exercise(1L,"Front Squat", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(2L,"Back Squat", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(3L,"Goblet Squat", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(4L,"OH Squat", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(5L,"Split Squat", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(6L,"Bulgarian Split Squat", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(7L,"Deadlift", Category.STRENGTH, SubCategory.DEADLIFT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(8L,"Kettlebell Deadlift", Category.STRENGTH, SubCategory.DEADLIFT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(9L,"Sumo Deadlift", Category.STRENGTH, SubCategory.DEADLIFT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(10L,"Single Leg Deadlift", Category.STRENGTH, SubCategory.SQUAT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(11L,"Barbell Row", Category.STRENGTH, SubCategory.ROWSTRENGTH, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(12L,"Dumbbell Row", Category.STRENGTH, SubCategory.ROWSTRENGTH, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(13L,"Chin-up", Category.STRENGTH, SubCategory.ROWSTRENGTH, MeasuringUnit.REPEATS));
//                exerciseRepo.save(new Exercise(14L,"Pull-up", Category.STRENGTH, SubCategory.ROWSTRENGTH, MeasuringUnit.REPEATS));
//                exerciseRepo.save(new Exercise(15L,"Push-up", Category.STRENGTH, SubCategory.PUSH, MeasuringUnit.REPEATS));
//                exerciseRepo.save(new Exercise(16L,"Bench Press", Category.STRENGTH, SubCategory.PUSH, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(17L,"Stricht Press", Category.STRENGTH, SubCategory.PUSH, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(18L,"Push Press", Category.STRENGTH, SubCategory.PUSH, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(19L,"Incline Bench Press", Category.STRENGTH, SubCategory.PUSH, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(20L,"Dumbbell Floor Press", Category.STRENGTH, SubCategory.PUSH, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(21L,"Farmers Walk", Category.STRENGTH, SubCategory.CARRY, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(22L,"Suitcase Walk", Category.STRENGTH, SubCategory.CARRY, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(23L,"Lunge", Category.STRENGTH, SubCategory.LUNGE, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(24L,"Power Clean", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(25L,"Hang Clean", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(26L,"Squat Clean", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(27L,"Push Jerk", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(28L,"Split Jerk", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(29L,"Snatch", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(30L,"Hang Snatch", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(31L,"Squat Snatch", Category.STRENGTH, SubCategory.OLYMPICLIFT, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(32L,"Single Under", Category.SKILL, SubCategory.JUMPINGROPE, MeasuringUnit.REPEATS));
//                exerciseRepo.save(new Exercise(33L,"Double Under", Category.SKILL, SubCategory.JUMPINGROPE, MeasuringUnit.REPEATS));
//                exerciseRepo.save(new Exercise(34L,"Pistols", Category.SKILL, SubCategory.PISTOLS, MeasuringUnit.REPEATS));
//                exerciseRepo.save(new Exercise(35L,"Box Jump", Category.SKILL, SubCategory.BOXJUMP, MeasuringUnit.CM));
//                exerciseRepo.save(new Exercise(36L,"Left", Category.SKILL, SubCategory.TGU, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(37L,"Right", Category.SKILL, SubCategory.TGU, MeasuringUnit.KG));
//                exerciseRepo.save(new Exercise(38L,"500m", Category.CARDIO, SubCategory.ROWCARDIO, MeasuringUnit.TIME));
//                exerciseRepo.save(new Exercise(39L,"1000m", Category.CARDIO, SubCategory.ROWCARDIO, MeasuringUnit.TIME));
//                exerciseRepo.save(new Exercise(40L,"2500m", Category.CARDIO, SubCategory.ROWCARDIO, MeasuringUnit.TIME));
//                exerciseRepo.save(new Exercise(41L,"5km", Category.CARDIO, SubCategory.ROWCARDIO, MeasuringUnit.TIME));
//                exerciseRepo.save(new Exercise(42L,"10km", Category.CARDIO, SubCategory.ROWCARDIO, MeasuringUnit.TIME));
//                exerciseRepo.save(new Exercise(43L,"500m", Category.CARDIO, SubCategory.SKI, MeasuringUnit.TIME));
//                exerciseRepo.save(new Exercise(44L,"1000m", Category.CARDIO, SubCategory.SKI, MeasuringUnit.TIME));
//                exerciseRepo.save(new Exercise(45L,"1 min", Category.CARDIO, SubCategory.AB, MeasuringUnit.CAL));
//                exerciseRepo.save(new Exercise(46L,"30 cal", Category.CARDIO, SubCategory.AB, MeasuringUnit.TIME));
//                exerciseRepo.save(new Exercise(47L,"Cindy", Category.WORKOUT, SubCategory.CINDY, MeasuringUnit.REPEATS));
//                exerciseRepo.save(new Exercise(48L,"100/200/300", Category.WORKOUT, SubCategory.MURPH, MeasuringUnit.TIME));
//                exerciseRepo.save(new Exercise(49L,"5/10/15", Category.WORKOUT, SubCategory.MURPH, MeasuringUnit.TIME));
//            }
//        };
//    }

}
