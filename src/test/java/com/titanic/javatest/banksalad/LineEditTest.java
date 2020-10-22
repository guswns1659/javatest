package com.titanic.javatest.banksalad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LineEditTest {

    private LineEdit lineEdit;

    @BeforeEach
    public void setUp() {
        lineEdit = new LineEdit();
    }

    @DisplayName("lineEdit 메서드 테스트")
    @ParameterizedTest
    @CsvSource({"abc d,3"})
    public void lineEdit(String input, int length) {
        // given
        String expected = new StringBuilder("abc").append("\n").append("d").toString();

        // when
        String answer = lineEdit.lineEdit(input, length);

        // then
        assertThat(answer).isEqualTo(expected);
    }
}