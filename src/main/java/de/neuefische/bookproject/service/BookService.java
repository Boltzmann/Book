package de.neuefische.bookproject.service;

import de.neuefische.bookproject.model.Book;
import de.neuefische.bookproject.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public boolean addBook(Book book){
        return bookRepo.addBook(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.getAllBooks();
    }

    public Book getBookIsbn(String isbn) {
        return bookRepo.getBookIsbn(isbn).orElseThrow(() -> (new NoSuchElementException("Cannot find a book with isbn " + isbn)));
    }

    public Book deleteBookByIsbn(String isbn) {
        return bookRepo.deleteBookByIsbn(isbn).orElseThrow(() -> (new NoSuchElementException("Cannot find a book with isbn " + isbn)));
    }
}
