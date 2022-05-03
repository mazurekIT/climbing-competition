package mazurek.it.climbingcompetition.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findUsersByLastName(@Param("name") String name);

    List<User> findUsersByPhone(@Param("phone") String phone);

}
