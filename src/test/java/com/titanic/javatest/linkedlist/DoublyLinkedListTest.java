package com.titanic.javatest.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @CsvSource({"data13, value13"})
    @ParameterizedTest
    void 양방향링크드리스트의_add를_테스트한다(String data13, String value13) {

        doublyLinkedList.traverse();
        assertThat(doublyLinkedList.add(new Node(data13, value13))).isEqualTo(value13);
        doublyLinkedList.traverse();
    }

    @CsvSource({"data13, value13, data9"})
    @ParameterizedTest
    void 양방향링크드리스트의_addBefore를_테스트한다(String data, String value, String beforeData) {

        assertThat(doublyLinkedList.addBefore(new Node(data, value), beforeData)).isEqualTo(value);
        doublyLinkedList.traverse();
    }

    @CsvSource({"data3, value3, data13, value13"})
    @ParameterizedTest
    void 양방향링크드리스트의_find를_테스트한다(String data3, String value3, String data13, String value13) {

        assertThat(doublyLinkedList.find(new Node(data3, value3))).isEqualTo(value3);
        assertThat(doublyLinkedList.find(new Node(data13, value13))).isEqualTo("fail");
    }
}
