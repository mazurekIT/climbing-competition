package mazurek.it.climbingcompetition.service;

import mazurek.it.climbingcompetition.exceptions.WallNotFoundException;
import mazurek.it.climbingcompetition.model.Wall;
import mazurek.it.climbingcompetition.repository.WallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallService {
    private final WallRepository wallRepository;

    public WallService(WallRepository wallRepository) {
        this.wallRepository = wallRepository;
    }

    public Wall addWall(Wall wall) {
        return wallRepository.save(wall);
    }

    public List<Wall> findAll() {
        return (List<Wall>) wallRepository.findAll();
    }

    public List<Wall> findByName(String name) {
        return wallRepository.findByName(name);
    }

    public Wall findById(Long id) {
        return wallRepository.findById(id).orElseThrow(() -> new WallNotFoundException(id));
    }
}
