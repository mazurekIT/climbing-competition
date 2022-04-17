package mazurek.it.climbingcompetition.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mazurek.it.climbingcompetition.addresses.Address;
import mazurek.it.climbingcompetition.gender.Gender;
import mazurek.it.climbingcompetition.roles.Role;
import mazurek.it.climbingcompetition.walls.Wall;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity // These tells Hibernate to make a table out of this class
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    @NonNull
    private String phone;
    @NonNull
    private String mail;
    @JsonIgnore//ten atrybut nie będzie wyświetlany w JSONie
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne
    private Address address;
    //    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Wall wall;


}
