package teun.demo.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private String name;
    private String address;
    private String email;
    private String dateOfBirth;
    private String length;
    private String weight;
    private List<Category> listOfCategories;
}