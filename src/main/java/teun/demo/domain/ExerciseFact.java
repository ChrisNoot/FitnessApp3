package teun.demo.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor(access =  AccessLevel.PUBLIC,force = true)
@Entity
public class ExerciseFact {

    @Id
    private Long id;

    private Date date;

    @PrePersist
    public void createDate() {
        this.date = new Date();
    }
}
