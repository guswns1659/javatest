package com.titanic.javatest.algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicProgrammingTest {

    @ParameterizedTest
    @CsvSource({"6, 5"})
    void DynamicProgramming알고리즘을_테스트한다(int number, int expected) {
        assertThat(DynamicProgramming.test(number)).isEqualTo(expected);
    }
}
