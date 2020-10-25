package com.titanic.javatest.dataStructure.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

public class SHA256Test {

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
