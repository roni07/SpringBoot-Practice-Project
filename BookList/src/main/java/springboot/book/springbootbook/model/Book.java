package springboot.book.springbootbook.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue
    private long isbn;
    @ManyToMany
    @JoinTable(name="BOOK_AUTHOR", joinColumns = @JoinColumn(name = "isbn"), inverseJoinColumns = @JoinColumn(name = "authorId"))
    private List<Author> authorList;
    private String publicationDate;
    private String bookTitle;
    /*@ManyToOne
    private Publisher publisher;*/
    private int edition;
}
