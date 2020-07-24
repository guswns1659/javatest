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
            Node newNode = new Node("data" + i, "value" + i);
            this.doublyLinkedList.add(newNode);
        }
    }

    @CsvSource({"Jack, 177"})
    @ParameterizedTest
    void 양방향링크드리스트의_add를_테스트한다(String name, String height) {

        doublyLinkedList.traverse();

        assertThat(doublyLinkedList.add(new Node(name, height))).isEqualTo(height);

        doublyLinkedList.traverse();

    }

    @CsvSource({"Jack, 177, data9"})
    @ParameterizedTest
    void 양방향링크드리스트의_addBefore를_테스트한다(String name, String height, String beforeData) {

        assertThat(doublyLinkedList.addBefore(new Node(name, height), beforeData)).isEqualTo(height);

        doublyLinkedList.traverse();
    }

}
