package com.titanic.javatest.enumtest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OperationTest {

    @Test
    void operatorGiven_ReturnAnswer() {
        double x = 3;
        double y = 4;
        String operator = "+";

        assertThat(Operation.fromString(operator).orElseThrow(() -> new RuntimeException()).apply(x,y)).isEqualTo(7);
    }
}
