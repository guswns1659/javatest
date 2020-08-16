package com.titanic.javatest.algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class QuickSortTest {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList(4,3,2,1,7,8,9,11))
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void QuickSort알고리즘을_테스트한다(List<Integer> unsorted) {
        System.out.println(QuickSort.quickSort(unsorted));
    }
}
