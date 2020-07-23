package com.titanic.javatest.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    private LinkedList linkedList;

    @BeforeEach
    void 링크드리스트를_생성한다() {
        linkedList = new LinkedList(new Node(null, 1));

        for (int i = 2; i < 11; i++) {
            linkedList.add(i);
        }
    }

    @CsvSource({"11, 12, 8, 20, -1"})
    @ParameterizedTest
    void 링크드리스트의_메서드를_테스트한다(Integer eleven, Integer twelve, Integer eight, Integer twenty, Integer empty) {

        linkedList.add(eleven);
        assertThat(linkedList.getTail().getData()).isEqualTo(eleven);
        linkedList.add(twelve);
        assertThat(linkedList.getTail().getData()).isEqualTo(twelve);

        linkedList.traverse();
        System.out.println();

        assertThat(linkedList.delete(eight)).isEqualTo(eight);

        linkedList.traverse();
        System.out.println();

        assertThat(linkedList.delete(twenty)).isEqualTo(empty);
    }
}
