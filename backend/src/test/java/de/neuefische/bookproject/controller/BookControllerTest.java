package de.neuefische.bookproject.controller;

import de.neuefische.bookproject.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private Book book1 = new Book("123456", "Momo");
    private Book book2 = new Book("23456", "Die unendliche Geschichte");

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getAllBooks() {
        webTestClient.get()
                .uri("http://localhost:" + port + "/book")
                .exchange()
                .expectStatus().is2xxSuccessful();

    }
}