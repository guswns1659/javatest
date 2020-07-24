package com.titanic.javatest.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DoublyLinkedListTest {

    private DoublyLinkedList doublyLinkedList;

    @BeforeEach
    void 양방향링크드리스트를_생성한다() {
        this.doublyLinkedList = new DoublyLinkedList();
        for (int i = 1; i < 10; i++) {
            this.doublyLinkedList.add(i);
        }
    }

    @CsvSource({"10"})
    @ParameterizedTest
    void 양방향링크드리스트의_add를_테스트한다(Integer ten) {

        doublyLinkedList.traverse();

        assertThat(doublyLinkedList.add(ten)).isEqualTo(ten);

        doublyLinkedList.traverse();

    }

    @CsvSource({"10, 9"})
    @ParameterizedTest
    void 양방향링크드리스트의_addBefore를_테스트한다(Integer ten, Integer nine) {

        assertThat(doublyLinkedList.addBefore(ten, nine)).isEqualTo(ten);

        doublyLinkedList.traverse();
    }

}
