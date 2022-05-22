package mazurek.it.climbingcompetition.repository;

import mazurek.it.climbingcompetition.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByMail(String mail);

    Optional<User> findUserByPhone(String phone);

}
