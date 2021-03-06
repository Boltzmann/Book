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

    public boolean addBook(Book book){
        return bookRepo.addBook(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.getAllBooks();
    }

    public Book getBookIsbn(String isbn) {
        return bookRepo.getBookIsbn(isbn);
    }

    public void deleteBookByIsbn(String isbn) {
        bookRepo.deleteBookByIsbn(isbn);
    }
}
