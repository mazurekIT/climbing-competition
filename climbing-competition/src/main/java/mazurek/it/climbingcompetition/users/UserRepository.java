package mazurek.it.climbingcompetition.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends CrudRepository<User, Long> {

//    SPRING sam dostarcza URLe do searcha po zdefiniowanych funkcjach
//    np. http://localhost:8080/users/search/findUsersByPhone?phone=668164072
//    nie jest to estetyczne ale działa
    List<User> findUsersByLastName(@Param("name") String name);
    List<User> findUsersByPhone(@Param("phone") String phone);

}
