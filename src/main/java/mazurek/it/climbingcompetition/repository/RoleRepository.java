package mazurek.it.climbingcompetition.repository;

import mazurek.it.climbingcompetition.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepository extends CrudRepository<Role, Long> {
}
