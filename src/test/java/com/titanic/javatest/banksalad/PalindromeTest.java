package com.titanic.javatest.banksalad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeTest {

    private Palindrome palindrome;

    @BeforeEach
    public void setUp() {
        palindrome = new Palindrome();
    }

    @DisplayName("palindrome solution 테스트")
    @ParameterizedTest
    @CsvSource({"ab"})
    public void solution(String input) {
        //given when, then
        assertThat(palindrome.solution(input)).isTrue();
    }
}