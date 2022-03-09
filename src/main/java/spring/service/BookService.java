package spring.service;

import org.springframework.stereotype.Component;
import spring.model.Book;
import spring.repository.BookRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class BookService {
    BookRepository bookRepository;
    private List<Book> bookList;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }

    public void deleteBook(String title){
        bookRepository.deleteByTitle(title);
    }

    // TODO: 3/5/2022
    // update book method
}
