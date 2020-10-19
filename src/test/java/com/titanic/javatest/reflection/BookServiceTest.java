package com.titanic.javatest.reflection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    public void di() {
        assertThat(bookService.bookRepository).isNotNull();
    }
}