package de.neuefische.bookproject.controller;

import de.neuefische.bookproject.model.Book;
import de.neuefische.bookproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book") // http://localhost:8080/book
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service){
        this.service = service;
    }

    @RequestMapping("/all")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @PostMapping
    public boolean addBook(Book book){
        return service.addBook(book);
    }

    @GetMapping(path="{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn){
        System.out.println(isbn);
        System.out.println(service.getBookIsbn(isbn));
        return service.getBookIsbn(isbn);
    }
}
