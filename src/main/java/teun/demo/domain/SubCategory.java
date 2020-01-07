package teun.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor(access =  AccessLevel.PUBLIC,force = true)
@Entity
@Table(name = "groupTable")
public class SubCategory {

    @Id
    private String id;

    private String name;

}
