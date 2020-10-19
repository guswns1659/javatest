package com.titanic.javatest.reflection.di;

import com.titanic.javatest.reflection.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContainerServiceTest {

    @DisplayName("리플랙션 이용한 BookRepository 객체 생성 테스트")
    @Test
    public void getObject_BookRepository() {
        BookRepository bookRepository = ContainerService.createInstance(BookRepository.class);
        assertThat(bookRepository).isNotNull();
    }

    @DisplayName("BookRepository를 필드로 가지고 있는 BookService의 의존성 주입 테스트")
    @Test
    public void getObject_BookService() {
        BookService bookService = ContainerService.getObject(BookService.class);
        assertThat(bookService).isNotNull();
        assertThat(bookService.bookRepository).isNotNull();
    }
}
