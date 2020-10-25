package com.titanic.javatest.dataStructure.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("해시테이블 테스트")
public class HashTableTest {

    private HashTable hashTable;

    @DisplayName("해시테이블 생성")
    @BeforeEach
    public void setUp() {
        hashTable = new HashTable(10);
        hashTable.put("Jack", "Hyunjun");
    }

    @DisplayName("해시테이블 put() 테스트")
    @ParameterizedTest
    @CsvSource({"Jack,hyunjun,1"})
    public void put(String key, String value, int expectedSize) {
        // when
        hashTable.put(key, value);

        // then
        assertAll(
                () -> assertThat(hashTable.size).isEqualTo(expectedSize),
                () -> assertThat(hashTable.get(key)).isEqualTo(value)
        );
    }

    @DisplayName("해시테이블 get() 호출 시 key가 있는 테스트")
    @ParameterizedTest
    @CsvSource({"Jack,Hyunjun"})
    public void getSuccess(String key, String expectedValue) {
        // when
        String value = hashTable.get(key);

        // then
        assertThat(value).isEqualTo(expectedValue);
    }

    @DisplayName("해시테이블 get() 호출 시 key가 없는 테스트")
    @ParameterizedTest
    @CsvSource({"jack"})
    public void getFail(String key) {
        // when, then
        assertThat(hashTable.get(key)).isNull();
    }
}
