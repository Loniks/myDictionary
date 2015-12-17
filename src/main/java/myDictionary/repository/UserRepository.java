package myDictionary.repository;

import myDictionary.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Bondar Dmytro.
 */
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Integer> {
    User findOneByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
