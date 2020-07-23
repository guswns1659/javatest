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

    @CsvSource({"11, 12"})
    @ParameterizedTest
    void 링크드리스트의_add를_테스트한다(Integer eleven, Integer twelve) {

        linkedList.add(eleven);
        assertThat(linkedList.getTail().getData()).isEqualTo(eleven);
        linkedList.add(twelve);
        assertThat(linkedList.getTail().getData()).isEqualTo(twelve);

        linkedList.traverse();
    }

    @CsvSource({"8, 20, -1"})
    @ParameterizedTest
    void 링크드리스트의_delete를_테스트한다(Integer eight, Integer twenty, Integer empty) {

        assertThat(linkedList.delete(eight)).isEqualTo(eight);

        linkedList.traverse();
        System.out.println();

        assertThat(linkedList.delete(twenty)).isEqualTo(empty);

    }

    @CsvSource({"8, 20, -1"})
    @ParameterizedTest
    void 링크드리스트의_find를_테스트한다(Integer eight, Integer twenty, Integer empty) {

        assertThat(linkedList.find(eight)).isEqualTo(eight);

        linkedList.traverse();
        System.out.println();

        assertThat(linkedList.find(twenty)).isEqualTo(empty);

    }
}
