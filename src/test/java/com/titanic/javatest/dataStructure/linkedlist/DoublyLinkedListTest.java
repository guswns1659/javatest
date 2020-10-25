package com.titanic.javatest.dataStructure.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DoublyLinkedListTest {

    private DoublyLinkedList doublyLinkedList;

    @BeforeEach
    void 양방향링크드리스트를_생성한다() {
        this.doublyLinkedList = new DoublyLinkedList();
        for (int i = 1; i < 10; i++) {
            LinkedListNode newNode = new LinkedListNode(i);
            this.doublyLinkedList.add(newNode);
        }
    }

    @DisplayName("링크드리스트의 traverse테스트")
    @Test
    void traverse() {
        // when
        doublyLinkedList.traverse();
    }

    @CsvSource({"13, 3, 33, 11"})
    @ParameterizedTest
    void 양방향링크드리스트의_add를_테스트한다(Integer value, Integer index, Integer value2, Integer eleven) {

        doublyLinkedList.traverse();
        assertThat(doublyLinkedList.add(new LinkedListNode(value))).isTrue();
        assertThat(doublyLinkedList.add(index, new LinkedListNode(value2))).isTrue();
        assertThat(doublyLinkedList.size()).isEqualTo(eleven);
        assertThatThrownBy(() -> doublyLinkedList.add(15, new LinkedListNode(value2)))
                .isInstanceOf(IndexOutOfBoundsException.class);
        doublyLinkedList.traverse();
    }

    @CsvSource({"3, 4, 5"})
    @ParameterizedTest
    void 양방향링크드리스트의_get을_테스트한다(Integer three, Integer four, Integer five) {

        assertThat(doublyLinkedList.get(three).getValue()).isEqualTo(four);
        assertThat(doublyLinkedList.get(four).getValue()).isEqualTo(five);
        assertThatThrownBy(() -> doublyLinkedList.get(15)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @CsvSource({"3, 4"})
    @ParameterizedTest
    void 양방향링크드리스트의_remove을_테스트한다(Integer index, Integer four) {
        doublyLinkedList.traverse();
        assertThat(doublyLinkedList.remove(index).getValue()).isEqualTo(four);
        doublyLinkedList.traverse();
    }
}
