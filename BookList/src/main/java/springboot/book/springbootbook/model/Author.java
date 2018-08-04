package springboot.book.springbootbook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue
    private long authorId;
    private String authorName;
    @ManyToMany(mappedBy = "books")
    private List<Book> authorBookList;
    @Embedded
    private Address address;
}
