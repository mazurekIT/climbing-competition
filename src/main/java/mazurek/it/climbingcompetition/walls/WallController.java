package mazurek.it.climbingcompetition.walls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WallController {
    private final WallService wallService;

    @Autowired
    public WallController(WallService wallService) {
        this.wallService = wallService;
    }

    @GetMapping("/wall")
    public List<Wall> getAll() {
        return wallService.findAll();
    }

    @PostMapping("/wall")
    public Wall addWall(@RequestBody Wall wall) throws ConstraintViolationException {
        return wallService.addWall(wall);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
