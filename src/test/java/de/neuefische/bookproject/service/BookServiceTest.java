package de.neuefische.bookproject.service;

import de.neuefische.bookproject.model.Book;
import de.neuefische.bookproject.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;

public class BookServiceTest {

    private final BookRepository bookRepo = new BookRepository();
    private final BookService bookService = new BookService(bookRepo);
    List<Book> bookList;

    @BeforeEach
    void fillBookListAndRepository(){
        bookList = asList(
                new Book("1", "Momo"),
                new Book("2", "Die unendliche Geschichte")
        );
        bookRepo.addBook(new Book("1", "Momo"));
        bookRepo.addBook(new Book("2", "Die unendliche Geschichte"));
    }

    @Test
    public void addBookWithUnmockedRepoTest(){
        // Given see fillBookListAndRepository.
        // When see above bookList.
        // Then
        List<Book> actual = bookRepo.getAllBooks();
        Assertions.assertEquals(bookList, actual);
    }

    @Test
    public void getBook_whenIsbnNotInRepo_giveNoSuchElementException(){
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> bookService.getBookIsbn("12121"));
    }

    @Test
    void deleteBookbyIsbn_whenBookPresent_shouldGetBookAndAllBooksHaveOneLess(){
        Book expected = new Book("2", "Die unendliche Geschichte");
        Assertions.assertEquals(expected, bookService.deleteBookByIsbn("2"));
    }

}
