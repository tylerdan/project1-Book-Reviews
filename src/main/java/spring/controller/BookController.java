package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping("{title}")
    public void deleteBook(@PathVariable String title) {
        bookService.deleteBook(title);
    }

    /*@PatchMapping(value="/update")
    public Book updateBook(@RequestBody Book book) {
        return bookService.patchBook(book);
    }*/

    // TODO: 3/5/2022
    // add @PatchMapping - update book info(?)
}
