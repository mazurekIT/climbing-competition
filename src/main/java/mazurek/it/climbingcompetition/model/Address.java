package mazurek.it.climbingcompetition.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public String getFullAddress() {
        return getCity() + " " + getStreet() + " " + getNumber();
    }
}
