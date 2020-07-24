package com.titanic.javatest.hashtable;

import com.titanic.javatest.linkedlist.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HashTableTest {

    private HashTable hashTable;

    @BeforeEach
    void 체이닝을_적용한_해시테이블을_생성한다() {
        this.hashTable = new HashTable();
        for (DoublyLinkedList doublyLinkedList : this.hashTable.getBucket()) {
            doublyLinkedList = new DoublyLinkedList();
        }
    }

    @ParameterizedTest
    @CsvSource({"Jack, 177", "solar, 160"})
    void 해시테이블의_put을_테스트한다(String person, String height) {

        assertThat(hashTable.put(person, height)).isEqualTo(height);
        assertThat(hashTable.put(person, height)).isEqualTo(height);
        this.hashTable.traverse();
    }
}
