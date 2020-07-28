package com.titanic.javatest.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeapTest {

    private Heap heap;

    @BeforeEach
    void 힙을_생성한다() {
        this.heap = new Heap();
    }

    @Test
    void 힙의_add를_테스트한다() {

        for (int odd = 1; odd < 10; odd+=2) {
            assertThat(this.heap.add(odd)).isTrue();
        }

        this.heap.traverse();
    }
}
