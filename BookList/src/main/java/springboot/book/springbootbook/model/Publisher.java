package springboot.book.springbootbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Publisher {
    @Id
    @GeneratedValue
    private long publisherId;
    private String name;
   /* @OneToMany
    private List<Book> publishedBookList;*/
    @Embedded
    private Address address;
}
