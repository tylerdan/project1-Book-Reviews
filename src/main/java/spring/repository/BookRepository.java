package spring.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.model.Book;

import java.util.List;

@Transactional
public interface BookRepository extends JpaRepository<Book, String> {
    Book save(Book book);
    List<Book> findAll();
    Book findByTitle(String title);
    List<Book> findAllByAuthor(String author);
    void deleteByTitle(String title);
}
