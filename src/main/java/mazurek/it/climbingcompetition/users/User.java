package mazurek.it.climbingcompetition.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import mazurek.it.climbingcompetition.addresses.Address;
import mazurek.it.climbingcompetition.gender.Gender;
import mazurek.it.climbingcompetition.roles.Role;
import mazurek.it.climbingcompetition.walls.Wall;

import javax.persistence.*;

@Entity // These tells Hibernate to make a table out of this class
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String lastName;
    private String phone;
    private String mail;

    //ten atrybut nie będzie wyświetlany w JSONie
    @JsonIgnore
    private String password;
    @Embedded
    private Gender gender;
    @JsonIgnore
    @Embedded
    private Role role;
    @OneToOne
    private Address address;
    //poniższy obiekt będzie zawart w tablicy User nie będzie tworzona osobna tabela
    @Embedded
    private Wall wall;


}
