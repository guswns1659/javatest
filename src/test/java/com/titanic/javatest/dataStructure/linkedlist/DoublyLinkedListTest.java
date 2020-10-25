package com.titanic.javatest.dataStructure.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("링크드리스트 테스트")
public class DoublyLinkedListTest {

    private DoublyLinkedList doublyLinkedList;

    @DisplayName("링크드리스트 생성")
    @BeforeEach
    public void setUp() {
        doublyLinkedList = new DoublyLinkedList();
        for (int value = 1; value < 11; value++) {
            doublyLinkedList.add(new LinkedListNode(value));
        }
    }

    @DisplayName("링크드리스트 add() 테스트")
    @ParameterizedTest
    @CsvSource({"10"})
    public void add(int expectedSize) {
        // then
        assertThat(doublyLinkedList.size).isEqualTo(expectedSize);
    }

    @DisplayName("링크드리스트 get() 테스트")
    @ParameterizedTest
    @CsvSource({"9,10"})
    public void get(int index, int expectedValue) {
        // when
        LinkedListNode foundNode = doublyLinkedList.get(index);

        // then
        assertThat(foundNode.value).isEqualTo(expectedValue);
    }

    @DisplayName("링크드리스트 remove() 테스트")
    @ParameterizedTest
    @CsvSource({"7,8,9"})
    public void remove(int index, int expectedValue, int expectedSize) {
        // when
        LinkedListNode removedNode = doublyLinkedList.remove(index);

        // then
        assertAll(
                () -> assertThat(removedNode.value).isEqualTo(expectedValue),
                () -> assertThat(doublyLinkedList.size).isEqualTo(expectedSize)
        );
    }
}