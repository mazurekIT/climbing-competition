package mazurek.it.climbingcompetition.model;

import mazurek.it.climbingcompetition.model.enums.Role;
import mazurek.it.climbingcompetition.model.enums.Sex;
import mazurek.it.climbingcompetition.model.enums.Wall;
import org.springframework.stereotype.Component;

@Component
public class User {

    private int id;
    private String name;
    private String lastName;
    private String phone;
    private String mail;
    private Sex sex;
    private Role role;
    private Access access;
    private Address address;
    private Wall wall;


}
