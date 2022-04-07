package de.neuefische.bookproject.service;

import de.neuefische.bookproject.model.Book;
import de.neuefische.bookproject.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

public class BookServiceMockedTest {

    private final BookRepository bookRepo = mock(BookRepository .class);
    private final BookService bookService = new BookService(bookRepo);
    List<Book> bookList;

    @BeforeEach
    void fillBookList(){
        bookList = asList(
                new Book("1", "Momo"),
                new Book("2", "Die unendliche Geschichte")
        );
    }

    @Test
    void addBook(){
        bookService.addBook(new Book("1", "Momo"));
        verify(bookRepo).addBook(new Book("1","Momo"));
    }

    @Test
    void getBooks(){
        // Given
        when(bookRepo.getAllBooks()).thenReturn(bookList);
        // When: expectation is bookList itself
        List<Book> expected = asList(
                new Book("1", "Momo"),
                new Book("2", "Die unendliche Geschichte")
        );
        // Then
        List<Book> actual = bookService.getAllBooks();

        verify(bookRepo).getAllBooks();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getBookIsbn(){
        // Given
        when(bookRepo.getBookIsbn("1")).thenReturn(Optional.of(new Book("1", "Momo")));
        // When
        Book actual = bookService.getBookIsbn("1");
        // Then
        verify(bookRepo).getBookIsbn("1");
        Assertions.assertEquals(new Book("1", "Momo"), actual);
    }

    @Test
    void deleteBookByIsbn(){
        bookService.deleteBookByIsbn("1");
        verify(bookRepo).deleteBookByIsbn("1");
    }
}
