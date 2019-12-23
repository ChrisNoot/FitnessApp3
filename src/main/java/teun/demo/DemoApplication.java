package teun.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import teun.demo.domain.Group;
import teun.demo.repository.GroupRepository;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(GroupRepository groupRepo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                groupRepo.save(new Group(1L,"19:00", new Date(), Group.Day.TUESDAY));
                groupRepo.save(new Group(2L,"20:00", new Date(), Group.Day.TUESDAY));
                groupRepo.save(new Group(3L,"21:00", new Date(), Group.Day.TUESDAY));
                groupRepo.save(new Group(4L,"18:00", new Date(), Group.Day.WEDNESDAY));
                groupRepo.save(new Group(5L,"19:00", new Date(), Group.Day.WEDNESDAY));
                groupRepo.save(new Group(6L,"19:00", new Date(), Group.Day.SATURDAY));
                groupRepo.save(new Group(7L,"18:00", new Date(), Group.Day.SATURDAY));
                groupRepo.save(new Group(8L,"21:00", new Date(), Group.Day.SUNDAY));







            }
        };
    }

}
