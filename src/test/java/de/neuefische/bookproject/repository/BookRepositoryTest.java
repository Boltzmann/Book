package de.neuefische.bookproject.repository;

import de.neuefische.bookproject.model.Book;
import de.neuefische.bookproject.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookRepositoryTest {

    private final BookRepository bookRepo = new BookRepository();
    List<Book> bookList;

    @BeforeEach
    void fillBookList(){
        bookList = asList(new Book("1", "Momo"), new Book("2", "Die unendliche Geschichte"));
    }

    @Test
    void addBook(){
        boolean isBookAdded = bookRepo.addBook(new Book("1", "Momo"));
        Assertions.assertTrue(isBookAdded);
    }

    @Test
    void getAllBooks() {
        // Given
        bookRepo.addBook(new Book("1", "Momo"));
        bookRepo.addBook(new Book("2", "Die unendliche Geschichte"));
        // When
        List<Book> expected = asList(
                new Book("1", "Momo"),
                new Book("2", "Die unendliche Geschichte")
        );
        // Then
        List<Book> actual = bookRepo.getAllBooks();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getBookIsbn() {
        // Given
        bookRepo.addBook(new Book("1", "Momo"));
        bookRepo.addBook(new Book("2", "Die unendliche Geschichte"));
        // When
        Book actual = bookRepo.getBookIsbn("1").orElseThrow();
        // Then
        Assertions.assertEquals(new Book("1", "Momo"), actual);
    }

    @Test
    void deleteBookByIsbn() {
        // Given
        bookRepo.addBook(new Book("1", "Momo"));
        bookRepo.addBook(new Book("2", "Die unendliche Geschichte"));
        // When
        // Then
        bookRepo.deleteBookByIsbn("1");
        List<Book> actual = bookRepo.getAllBooks();
        Assertions.assertEquals(List.of(new Book("2", "Die unendliche Geschichte")), actual);
    }
}