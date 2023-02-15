package libraryproject.springframework.libraryproject.model.repositories;

import libraryproject.springframework.libraryproject.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author, Long> {
}
