package mazurek.it.climbingcompetition.walls;

import lombok.RequiredArgsConstructor;
import mazurek.it.climbingcompetition.BasicController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/walls")
@RequiredArgsConstructor
public class WallController extends BasicController {
    private final WallService wallService;

    @GetMapping
    public List<Wall> getWalls() {
        return wallService.findAll();
    }

    @GetMapping("{id}")
    public Wall getWallById(@PathVariable Long id) {
        return wallService.findById(id);
    }

    @GetMapping("{name}")
    public List<Wall> getWallByName(@PathVariable String name) {
        return wallService.findByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Wall addWall(@Valid @RequestBody Wall wall) {
        return wallService.addWall(wall);
    }
}
