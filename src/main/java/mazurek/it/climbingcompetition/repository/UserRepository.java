package mazurek.it.climbingcompetition.repository;

import mazurek.it.climbingcompetition.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

}
