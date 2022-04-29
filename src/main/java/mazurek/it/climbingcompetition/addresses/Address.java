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

    @NotBlank(message = "Address - City can't be blank.")
    private String city;

    @NotBlank(message = "Address - Street can't be blank.")
    private String street;

    @NotBlank(message = "Address - Number can't be blank.")
    private String number;
}
