package com.titanic.javatest.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

public class HashTableTest {

    private HashTable hashTable;

    @BeforeEach
    void 체이닝을_적용한_해시테이블을_생성한다() {
        this.hashTable = new HashTable();
    }

    @ParameterizedTest
    @CsvSource({"Jack, 177, Jack, 160"})
    void 해시테이블의_put을_테스트한다(String person, String height, String person2, String height2) {
        assertThat(hashTable.put(person, height)).isEqualTo(height);
        assertThat(hashTable.put(person2, height2)).isEqualTo(height2);
        this.hashTable.traverse();
    }

    @ParameterizedTest
    @CsvSource({"jack"})
    void 해시256함수를_테스트한다(String name) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(name.getBytes(StandardCharsets.UTF_8));
        String shaHash = new String(hash, StandardCharsets.UTF_8);
        System.out.println("shaHash : " + shaHash);

        String hex = "100";
        System.out.println(Integer.parseInt(hex, 2));
    }
}
