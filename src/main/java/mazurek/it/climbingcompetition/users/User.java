package mazurek.it.climbingcompetition.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity // These tells Hibernate to make a table out of this class
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "last name is required")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "last name is required")
    private String lastName;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    @Email
    @NotBlank(message = "email is required")
    private String mail;

    @Column(nullable = false)
    private String password;

//    @OneToOne
//    @JoinColumn(name = "address_id")
//    private Address address;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;
//    //    @Enumerated(EnumType.STRING)
//    private Gender gender;
////    private List<Wall> wall;


}
