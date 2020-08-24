package com.titanic.javatest.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {

    private List<Integer> list;
    private BinarySearch binarySearch;

    @BeforeEach
    void setUp() {
        this.list = new ArrayList<>();
        this.binarySearch = new BinarySearch();

        for (int number = 0; number < 101; number++) {
            this.list.add(number);
        }
    }

    @ParameterizedTest
    @CsvSource({"78", "200"})
    void 이진탐색을_테스트한다(int goal) {
        assertThat(this.binarySearch.search(this.list, goal)).isTrue();
    }

}
