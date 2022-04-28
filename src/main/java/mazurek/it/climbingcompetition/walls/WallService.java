package mazurek.it.climbingcompetition.walls;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class WallService {
    private Validator validator;
    private WallRepository wallRepository;

    public WallService(Validator validator, WallRepository wallRepository) {
        this.validator = validator;
        this.wallRepository = wallRepository;
    }

    public Wall addWall(Wall wall) {
        //check field of Wall with annotation
        Set<ConstraintViolation<Wall>> violations = validator.validate(wall);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Wall> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb, violations);
        }
        return wallRepository.save(wall);
    }

    public List<Wall> findAll() {
        return (List<Wall>) wallRepository.findAll();
    }

    public List<Wall> findByName(String name) {
        return wallRepository.findByName(name);
    }


}
