package mazurek.it.climbingcompetition.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mazurek.it.climbingcompetition.model.enums.Gender;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    private String phone;

    @Column(nullable = false, unique = true)
    @Email
    @NotBlank(message = "User - email is required.")
    private String mail;

    @Column(nullable = false)
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
