package mazurek.it.climbingcompetition.walls;

import mazurek.it.climbingcompetition.model.Address;
import mazurek.it.climbingcompetition.model.Wall;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WallTest {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void nameIsNull() {
        Wall wall = new Wall();
        Set<ConstraintViolation<Wall>> constraintViolations = validator.validate(wall);
        assertEquals(1, constraintViolations.size());
        assertEquals("Wall - name is required.", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void nameIsBlank() {
        Wall wall = new Wall();
        wall.setName("");
        Set<ConstraintViolation<Wall>> constraintViolations = validator.validate(wall);
        assertEquals(1, constraintViolations.size());
        assertEquals("Wall - name is required.", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void wallWithoutAddressIsValid() {
        Wall wall = new Wall();
        wall.setName("Karma");
        Set<ConstraintViolation<Wall>> constraintViolations = validator.validate(wall);
        assertEquals(0, constraintViolations.size());
    }

    @Test
    public void wallWithAddressIsValid(){
        Address address = new Address();
        address.setCity("Poz");
        address.setStreet("Sol");
        address.setNumber("2");
        Wall wall = new Wall();
        wall.setName("Karma");
        wall.setAddress(address);
        Set<ConstraintViolation<Wall>> constraintViolations = validator.validate(wall);
        assertEquals(0, constraintViolations.size());

    }
}