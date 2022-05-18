package mazurek.it.climbingcompetition.repository;

import mazurek.it.climbingcompetition.model.Wall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface WallRepository extends JpaRepository<Wall, Long> {
    List<Wall> findByName(String name);
}
