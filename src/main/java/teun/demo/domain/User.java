package teun.demo.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    @ManyToMany(targetEntity = Category.class)
    private List<Category> listOfCategories;

    @PrePersist
    public void createdAt() {
        createdAt = new Date();
    }

}