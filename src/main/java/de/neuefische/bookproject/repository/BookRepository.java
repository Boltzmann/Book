package de.neuefische.bookproject.repository;

import de.neuefische.bookproject.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRepository {
    public void addBook(Book book) {
    }

    public List<Book> getAllBooks() {
        return null;
    }


    public Book getBookIsbn(String isbn) {
        return null;
    }

    public void deleteBookByIsbn(String isbn) {
    }
}
