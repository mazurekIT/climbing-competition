package mazurek.it.climbingcompetition.walls;

import lombok.Data;
import mazurek.it.climbingcompetition.addresses.Address;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Wall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Wall - name is required.")
    //    @Valid
    private String name;

    //    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

}
