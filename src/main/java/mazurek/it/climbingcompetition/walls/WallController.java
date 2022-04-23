package mazurek.it.climbingcompetition.walls;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WallController {
    private final WallRepository wallRepository;

    public WallController(WallRepository wallRepository) {
        this.wallRepository = wallRepository;
    }

    @GetMapping("/wall")
    public Iterable<Wall> getAll(){
        return wallRepository.findAll();
    }

    @PostMapping("/wall")
    public Wall addWall(@RequestBody Wall wall){
        return wallRepository.save(wall);
    }

}
