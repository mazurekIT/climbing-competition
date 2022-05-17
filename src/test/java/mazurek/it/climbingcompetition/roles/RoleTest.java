package mazurek.it.climbingcompetition.roles;

import mazurek.it.climbingcompetition.model.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RoleTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void nameIsBlank() {
        Role role = new Role();
        Set<ConstraintViolation<Role>> constraintViolations = validator.validate(role);

        assertEquals(1, constraintViolations.size());
        assertEquals("Role - name is required.", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void roleIsValid() {
        Role role = new Role();
        role.setName("admin");
        Set<ConstraintViolation<Role>> constraintViolations = validator.validate(role);

        assertEquals(0, constraintViolations.size());
    }

}