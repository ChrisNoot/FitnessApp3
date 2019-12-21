package teun.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor(access =  AccessLevel.PUBLIC,force = true)
@Data
@Table(name="userTable")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String email;

    @NotNull
    private String dateOfBirth;

    @NotNull
    private String length;

    @NotNull
    private String weight;

    public void createdAt() {
        createdAt = new Date();
    }

}