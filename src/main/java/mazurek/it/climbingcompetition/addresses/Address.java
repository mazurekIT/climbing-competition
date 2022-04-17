package mazurek.it.climbingcompetition.addresses;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String street;
    private String number;
}
