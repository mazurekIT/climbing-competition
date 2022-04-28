package mazurek.it.climbingcompetition.walls;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "wall", path = "wall")
public interface WallRepository extends CrudRepository<Wall, Long> {
    List<Wall> findByName(String name);
}
