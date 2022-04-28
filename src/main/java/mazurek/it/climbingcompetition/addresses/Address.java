package mazurek.it.climbingcompetition.addresses;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "City can't be blank")
    private String city;

    @NotBlank(message = "Street can't be blank")
    private String street;

    @NotBlank(message = "Number can't be blank")
    private String number;
}
