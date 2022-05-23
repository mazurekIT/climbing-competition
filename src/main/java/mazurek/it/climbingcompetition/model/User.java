package mazurek.it.climbingcompetition.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mazurek.it.climbingcompetition.model.enums.Gender;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "User - last name is required.")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "User - last name is required.")
    private String lastName;

    @Column(nullable = false, unique = true)
//    @Digits(message = "User - phone should contain only digits") //TODO this annotation works for number type
    private String phone;

    @Column(nullable = false, unique = true)
    @Email
    @NotBlank(message = "User - email is required.")
    private String mail;

    @Column(nullable = false)
    @Size(min = 5, message = "User - password should be min 5 long.")
    @NotBlank
    private String password;

    @OneToOne
    private Address address;

    @ManyToOne
    private Role role;

    @ManyToMany(mappedBy = "user")
    private List<Wall> wall = new ArrayList<>();

    @NotNull
    private Gender gender;

}
