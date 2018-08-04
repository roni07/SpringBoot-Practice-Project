package springboot.book.springbootbook.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.book.springbootbook.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
}
