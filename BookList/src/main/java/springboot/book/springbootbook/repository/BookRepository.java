package springboot.book.springbootbook.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.book.springbootbook.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
