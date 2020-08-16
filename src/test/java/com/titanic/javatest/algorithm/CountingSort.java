package com.titanic.javatest.algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CountingSort {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(new int[]{4, 5, 7, 8, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void CountingSort알고리즘을_테스트한다(int[] numbers) {
        Counting.sort(numbers);
    }
}
