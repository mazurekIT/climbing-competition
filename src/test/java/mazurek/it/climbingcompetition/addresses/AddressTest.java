package mazurek.it.climbingcompetition.addresses;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AddressTest {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void cityIsBlank() {
        Address address = new Address();
        address.setStreet("Street");
        address.setNumber("2");
        Set<ConstraintViolation<Address>> constraintViolations = validator.validate(address);
        assertEquals(1, constraintViolations.size());
        assertEquals("Address - City can't be blank.", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void streetIsBlank() {
        Address address = new Address();
        address.setCity("City");
        address.setNumber("2");
        Set<ConstraintViolation<Address>> constraintViolations = validator.validate(address);
        assertEquals(1, constraintViolations.size());
        assertEquals("Address - Street can't be blank.", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void numberIsBlank() {
        Address address = new Address();
        address.setStreet("Street");
        address.setCity("Poz");
        Set<ConstraintViolation<Address>> constraintViolations = validator.validate(address);
        assertEquals(1, constraintViolations.size());
        assertEquals("Address - Number can't be blank.", constraintViolations.iterator().next().getMessage());
    }


    @Test
    public void allFieldsAllBlank() {
        Address address = new Address();
        Set<ConstraintViolation<Address>> constraintViolations = validator.validate(address);
        assertEquals(3, constraintViolations.size());
    }

    @Test
    public void addressIsValid() {
        Address address = new Address();
        address.setNumber("2");
        address.setStreet("Street");
        address.setCity("Poz");
        Set<ConstraintViolation<Address>> constraintViolations = validator.validate(address);
        assertEquals(0, constraintViolations.size());
    }
}