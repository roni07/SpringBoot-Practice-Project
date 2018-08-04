package springboot.book.springbootbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.book.springbootbook.model.Address;
import springboot.book.springbootbook.model.Author;
import springboot.book.springbootbook.model.Book;
import springboot.book.springbootbook.model.Publisher;
import springboot.book.springbootbook.repository.AuthorRepository;
import springboot.book.springbootbook.repository.BookRepository;
import springboot.book.springbootbook.repository.PublisherRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository,
                          PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }


    @PostMapping(value = "saveBook")
    @ResponseBody
    public Book saveBook(@RequestBody Book book) {

        if(book.getAuthorList() != null){
            for (Author author : book.getAuthorList()){
                authorRepository.save(author);
            }
        }

     /*   if(book.getPublisher() != null){
            publisherRepository.save(book.getPublisher());
        } */

        bookRepository.save(book);
        return book;
    }

    @GetMapping(value = "getBook")
    @ResponseBody
    public Iterable<Book> getBook(){
        return bookRepository.findAll();
    }

    // Author

    @PostMapping(value = "saveAuthor")
    @ResponseBody
    public Author saveAuthor(@RequestBody Author author) {

        if(author.getAuthorBookList() != null){
            for (Book book : author.getAuthorBookList()){
                bookRepository.save(book);
            }
        }

        authorRepository.save(author);
        return author;
    }

    @GetMapping(value = "getAuthor")
    @ResponseBody
    public Iterable<Author> getAuthor(){
        return authorRepository.findAll();
    }

    //Publisher

    @PostMapping(value = "savePublisher")
    @ResponseBody
    public Publisher getAuthor(@RequestBody Publisher publisher) {

     /*   if(publisher.getPublishedBookList() != null){
            for (Book book : publisher.getPublishedBookList()){
                bookRepository.save(book);
            }
        }  */

        publisherRepository.save(publisher);
        return publisher;
    }

    @GetMapping(value = "getPublisher")
    @ResponseBody
    public Iterable<Publisher> getPublisher(){
        return publisherRepository.findAll();
    }

    @GetMapping(value = "test")
    @ResponseBody
    public Iterable<Book> bookTest() {
        Book book = new Book();
        Publisher publisher = new Publisher();
        publisher.setAddress(new Address("250","BD","Dhaka","1213"));
        publisher.setName("Kamrul");


        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setAuthorName("Roni");
        author.setAddress(new Address("150","BD","Dhaka","1213"));

        Author author1 = new Author();
        author1.setAuthorName("Mehedi");
        author1.setAddress(new Address("150","BD","Dhaka","1213"));
        authors.add(authorRepository.save(author));
        authors.add(authorRepository.save(author1));

        book.setAuthorList(authors);

//        book.setPublisher(publisherRepository.save(publisher));

        book.setPublicationDate("21/03/2017");
        book.setBookTitle("jhj");
        book.setEdition(5);

        bookRepository.save(book);



        return bookRepository.findAll();
    }

}
