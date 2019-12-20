package teun.demo.domain;

import lombok.Data;

import javax.persistence.Id;


@Data
public class Exercise {

    @Id
    private String id;

    private String name;
    private String score;
}

