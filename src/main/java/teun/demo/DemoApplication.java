package teun.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import teun.demo.domain.Group;
import teun.demo.domain.User;
import teun.demo.repository.GroupRepository;
import teun.demo.repository.UserRepository;

import java.util.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(GroupRepository groupRepo, UserRepository userRepo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Group group1 = new Group(1L,"19:00", new Date(), Group.Day.TUESDAY);
                Group group2 = new Group(2L,"20:00", new Date(), Group.Day.TUESDAY);
                groupRepo.save(group1);
                groupRepo.save(group2);
                groupRepo.save(new Group(3L,"21:00", new Date(), Group.Day.TUESDAY));
                groupRepo.save(new Group(4L,"18:00", new Date(), Group.Day.WEDNESDAY));
                groupRepo.save(new Group(5L,"19:00", new Date(), Group.Day.WEDNESDAY));
                groupRepo.save(new Group(6L,"19:00", new Date(), Group.Day.SATURDAY));
                groupRepo.save(new Group(7L,"18:00", new Date(), Group.Day.SATURDAY));
                groupRepo.save(new Group(8L,"21:00", new Date(), Group.Day.SUNDAY));
                List<Group> testGroups = new ArrayList<>();
                testGroups.add(group1);
                testGroups.add(group2);
                userRepo.save(new User(1L, new Date(), "teun", "teunajax", "70",
                        "180", "15-05-1992", "chris.nooteboom@gmail.com", "0618571699", testGroups)
                );
            }
        };
    }

}
