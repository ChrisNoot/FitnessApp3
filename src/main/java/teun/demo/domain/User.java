package teun.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Data
@Table(name = "userTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotBlank(message = "Gebruikersnaam error, gebruik een andere")
    private String name;

    @Pattern(regexp = "^\\S*$", message = "Gebruikersnaam moet uit 1 woord bestaan")
    @NotBlank(message = "Dit veld mag niet leeg zijn")
    private String username;

    private String weight;
    private String length;

    @Pattern(regexp = "((0[1-9]|[12]\\d|3[01])-(0[1-9]|1[0-2])-[12]\\d{3})", message = "Gebruik het format dd-mm-jjjj")
    private String dateOfBirth;

    @NotBlank
    @Email(message = "Gebruik een correcte email")
    private String email;

    @Pattern(regexp = "^06\\d{8}$", message = "Gebruik een 06 nummer")
    private String phoneNumber;

    @PrePersist
    public void createdAt() {
        createdAt = new Date();
    }

    @ManyToMany
    @Size(min = 1, message = "Kies minimaal 1 groep.")
    private List<Crowd> crowds = new ArrayList<>();

    @OneToMany
    private Set<ExerciseFact> exerciseFacts = new HashSet<>();

    @Override
    public String toString() {
        return this.name;
    }

    public User(Long id,
                Date date,
                String name,
                String username,
                String gewicht,
                String length,
                String dateOfBirth,
                String email,
                String phoneNumber,
                List<Crowd> groups) {
        this.id = id;
        this.createdAt = date;
        this.name = name;
        this.username = username;
        this.weight = gewicht;
        this.length = length;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.crowds = groups;
    }

}