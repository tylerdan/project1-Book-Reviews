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

    @PostMapping("postBook" /*consumes = {"application/xml","application/json"}*/)
    public Book postBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("bookauthor/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author){
        return bookService.findBooksByAuthor(author);
    }

    @DeleteMapping(value="/{title}")
    public void deleteBook(@PathVariable String title) {
        bookService.deleteBook(title);
    }

    /*@PatchMapping(value="/update/{title}/{author}/{yearPublish}")
    public Book updateBook(@PathVariable String title, @PathVariable String author, @PathVariable int yearPublish) {
        return bookService.patchBook(title, author, yearPublish);
    }*/

    // TODO: 3/5/2022
    // add @PatchMapping - update book info(?)
}
