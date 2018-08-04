package springboot.book.springbootbook.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.book.springbootbook.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
}
