package de.neuefische.bookproject.service;

import de.neuefische.bookproject.model.Book;
import de.neuefische.bookproject.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addBook(Book book){
        bookRepo.addBook(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.getAllBooks();
    }
}
