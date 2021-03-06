package mazurek.it.climbingcompetition.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import mazurek.it.climbingcompetition.model.Address;
import mazurek.it.climbingcompetition.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties(value = {"user"})
public class Wall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Wall - name is required.")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany
    private List<User> user = new ArrayList<>();

}
