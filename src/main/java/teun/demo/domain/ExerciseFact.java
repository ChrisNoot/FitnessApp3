package teun.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@NoArgsConstructor(access =  AccessLevel.PUBLIC,force = true)
@Data
@Slf4j
public class ExerciseFact {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private LocalDateTime date;
    private Long score;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne
    private Exercise exercise;

    @PrePersist
    public void createDate() {
        this.date = LocalDateTime.now();
    }
}