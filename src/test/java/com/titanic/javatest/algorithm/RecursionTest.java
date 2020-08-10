package com.titanic.javatest.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RecursionTest {

    private Recursion recursion;

    @BeforeEach
    void Recursion을_생성한다() {
        this.recursion = new Recursion();
    }

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, 6),
                Arguments.of(new int[]{4,5,6}, 15)
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void sumList를_테스트한다 (int[] numbers, int expected) {
        assertThat(this.recursion.sumList(numbers)).isEqualTo(expected);
    }
}
