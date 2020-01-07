package teun.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor(access =  AccessLevel.PUBLIC,force = true)
@Entity
public class Exercise {

    @Id
    private String id;

    private String name;
    private String score;

    private Category category;

    private Set<Category> listOfCategories;


}

