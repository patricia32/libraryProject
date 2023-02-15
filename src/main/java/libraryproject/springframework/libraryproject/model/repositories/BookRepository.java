package libraryproject.springframework.libraryproject.model.repositories;

import libraryproject.springframework.libraryproject.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Long> {
}
