package libraryproject.springframework.libraryproject.model.repositories;

import libraryproject.springframework.libraryproject.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}
