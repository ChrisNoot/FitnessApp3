package teun.demo.domain;

import lombok.Data;

import javax.persistence.Id;


@Data
public class Exercise {

    private String id;

    private String name;
    private String score;
}

