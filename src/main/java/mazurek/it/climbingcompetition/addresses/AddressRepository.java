package mazurek.it.climbingcompetition.addresses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AddressRepository extends CrudRepository<Address, Long> {
}
