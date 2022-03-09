package spring.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.model.Book;

import java.util.List;

@Transactional
public interface BookRepository extends JpaRepository<Book, String> {
    Book save(Book book);
    @Query("from Book")
    List<Book> findAll();
    @Query("from Book where title = :title")
    Book findByTitle(String title);
    @Query("from Book where author = :author")
    List<Book> findAllByAuthor(String author);
    //@Query("from Book where title = :title")
    void deleteByTitle(String title);
    /*@Query("Update Book Set author = :author, year_publish = :yearPublish where title = :title")
    Book patchByTitle(String title, String author, int yearPublish);*/
    // TODO: 3/5/2022
    //update book method
}
