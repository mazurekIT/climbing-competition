package mazurek.it.climbingcompetition.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties(value = {"user"})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Role - name is required.")
    private String name;


    @OneToMany(mappedBy = "role")
    private List<User> user = new ArrayList<>();
}
