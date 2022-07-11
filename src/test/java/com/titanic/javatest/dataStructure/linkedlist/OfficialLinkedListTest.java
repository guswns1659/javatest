package com.titanic.javatest.dataStructure.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자바 공식 LinkedList 테스트")
public class OfficialLinkedListTest {

    private List<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>(List.of(1,2,3,4,5));
    }

    @DisplayName("prev와 next를 정상적으로 가져온다.")
    @Test
    void iterator() {
        int index = 2;
        ListIterator<Integer> iterator = linkedList.listIterator(index - 1);

        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.previous()).isEqualTo(2);
        iterator.next();
        iterator.next();
        assertThat(iterator.next()).isEqualTo(4);
    }
}
