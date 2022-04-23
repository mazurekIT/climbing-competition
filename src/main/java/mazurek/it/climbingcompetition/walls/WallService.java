package mazurek.it.climbingcompetition.walls;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class WallService {
    private Validator validator;
    private WallRepository wallRepository;

    public Wall addWall(Wall wall){
        Set<ConstraintViolation<Wall>> violations = validator.validate(wall);

        if(!violations.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Wall> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb, violations);
        }
        return wallRepository.save(wall);
    }

    public List<Wall> findAll(){
        return (List<Wall>) wallRepository.findAll();
    }


}
