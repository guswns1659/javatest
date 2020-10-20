package com.titanic.javatest.dip;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("DIP로 구현한 Calculator 테스트")
    @ParameterizedTest
    @CsvSource({"1,2,2"})
    public void calculate(int num1, int num2, int expected) {
        // given
        Calculator sumCalculator = CalculatorFactory.instance().getCalculator("multi");

        // when, then
        assertThat(sumCalculator.calculate(num1, num2)).isEqualTo(expected);
    }
}
