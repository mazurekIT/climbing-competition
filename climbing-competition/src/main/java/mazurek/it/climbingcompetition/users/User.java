package mazurek.it.climbingcompetition.users;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String lastName;
    private String phone;
    private String mail;
    private String password;
//    private Gender gender;
//    private Role role;
//    private Address address;
//    private Wall wall;



}
