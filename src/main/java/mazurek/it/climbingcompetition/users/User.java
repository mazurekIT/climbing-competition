package mazurek.it.climbingcompetition.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mazurek.it.climbingcompetition.gender.Gender;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    @Email
    @NotBlank(message = "User - email is required.")
    private String mail;

    @Column(nullable = false)
    @NotBlank
    private String password;

    //    @OneToOne
//    @JoinColumn(name = "address_id")
//    private Address address;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;
////    private List<Wall> wall;

    @NotNull
    private Gender gender;

}
