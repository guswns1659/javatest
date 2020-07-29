package com.titanic.javatest.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HeapTest {

    private Heap heap;

    @BeforeEach
    void 힙을_생성한다() {
        this.heap = new Heap();

        for (int odd = 1; odd < 10; odd+=2) {
            assertThat(this.heap.add(odd)).isTrue();
        }
    }

    @CsvSource({"10, 1"})
    @ParameterizedTest
    void 힙의_add를_테스트한다(Integer ten, Integer one) {

        this.heap.add(ten);
        assertThat(this.heap.getHeap().get(one)).isEqualTo(ten);
        this.heap.traverse();
    }

    @Test
    void 힙의_pop을_테스트한다() {

        this.heap.traverse();
        assertThat(this.heap.pop()).isEqualTo(9);
        assertThat(this.heap.pop()).isEqualTo(7);
        this.heap.traverse();
    }
}
