package mazurek.it.climbingcompetition.walls;

import mazurek.it.climbingcompetition.BasicController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WallController extends BasicController {
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
    public Wall addWall(@Valid @RequestBody Wall wall) {
        return wallService.addWall(wall);
    }
}
