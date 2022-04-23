package mazurek.it.climbingcompetition.walls;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WallRepository extends JpaRepository<Wall, Long> {
}
