package de.neuefische.bookproject.repository;

import de.neuefische.bookproject.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookRepository {

    private final Map<String, Book> repo = new HashMap<>();

    public boolean addBook(Book book) {
        return null == repo.put(book.getIsbn(), book);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(repo.values());
    }


    public Book getBookIsbn(String isbn) {
        return repo.get(isbn);
    }

    public void deleteBookByIsbn(String isbn) {
        repo.remove(isbn);
    }
}
