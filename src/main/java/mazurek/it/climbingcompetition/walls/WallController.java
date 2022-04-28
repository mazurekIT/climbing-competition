package mazurek.it.climbingcompetition.walls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/wall/{name}")
    public List<Wall> getWallByName(@PathVariable String name) {
        return wallService.findByName(name);
    }

    @PostMapping("/wall")
    public Wall addWall(
            @Valid
            @RequestBody Wall wall) {
        return wallService.addWall(wall);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
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
