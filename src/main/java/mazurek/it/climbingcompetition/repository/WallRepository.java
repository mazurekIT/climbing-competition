package mazurek.it.climbingcompetition.repository;

import mazurek.it.climbingcompetition.model.Wall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface WallRepository extends CrudRepository<Wall, Long> {
    List<Wall> findByName(String name);
}
