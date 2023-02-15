package libraryproject.springframework.libraryproject.model.repositories;

import libraryproject.springframework.libraryproject.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
