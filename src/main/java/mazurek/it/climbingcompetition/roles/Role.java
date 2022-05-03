package mazurek.it.climbingcompetition.roles;

import lombok.Data;
import mazurek.it.climbingcompetition.users.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Role - name is required.")
    private String name;


    @OneToMany
    private List<User> user = new ArrayList<>();
}
