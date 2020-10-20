package com.titanic.javatest.reflection.di;

import com.titanic.javatest.reflection.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContainerServiceTest {

    @DisplayName("리플랙션 이용해서 ShoeService에 필드 주입 테스트")
    @Test
    void getObject_ShoeService() {
        ShoeService shoeService = ContainerService.getObject(ShoeService.class);
        assertThat(shoeService).isNotNull();
        assertThat(shoeService.shoeRepository).isNotNull();
    }

    @DisplayName("리플랙션 이용해서 ShoeRepository 객체 생성 테스트")
    @Test
    void getInstance_ShoeRepository() throws IllegalAccessException {
        ShoeRepository shoeRepository = ContainerService.createInstance(ShoeRepository.class);
        assertThat(shoeRepository).isNotNull();
    }
}
