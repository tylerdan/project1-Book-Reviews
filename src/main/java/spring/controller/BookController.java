package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.aspect.BookAspect;
import spring.service.BookService;
import spring.model.Book;

import java.util.List;


@RestController
public class BookController {
    BookService bookService;
    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBook(){
        return bookService.findAllBooks();
    }

    @GetMapping("{title}")
    public Book getBookByName(@PathVariable String title){
        return bookService.findBookByTitle(title);
    }

    @PostMapping("postbook")
    public Book postBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("bookauthor/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author){
        return bookService.findBooksByAuthor(author);
    }

    @DeleteMapping("deletebook/{title}")
    public void deleteBook(@PathVariable String title) {
        bookService.deleteBook(title);
        BookAspect.log.info("Successfully deleted record with title: " + title);
    }

    @PatchMapping("update/{title}")
    public Book updateBook(@PathVariable String title, @RequestBody Book book) {
        Book savedBook = getBookByName(title);
        if (savedBook!=null) {// check if there's an entry in the database for a book of this title
            if (book.getAuthor() != null) {
                savedBook.setAuthor(book.getAuthor());
            }
            System.out.println(book.getYearPublish());
            if (book.getYearPublish() != 0) {
                savedBook.setYearPublish(book.getYearPublish());
            }
            return bookService.patchBook(savedBook);
        } else { // create new entry if there isn't already an entry for book 'title' in db
            return bookService.saveBook(book);
        }
    }

    // TODO: 3/5/2022
    // add @PatchMapping - update book info(?)
}
