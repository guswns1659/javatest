package com.titanic.javatest.algorithm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {

    private List<Integer> list;
    private BinarySearch binarySearch;
    private long startTime;
    private long endTime;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        binarySearch = new BinarySearch();

        for (int number = 0; number < 101; number++) {
            list.add(number);
        }
        startTime = System.nanoTime();
    }

    @ParameterizedTest
    @CsvSource({"78"})
    void 이진탐색을_테스트한다(int goal) {
        assertThat(binarySearch.search(list, goal)).isTrue();
    }

    @AfterEach
    void tearDown() {
        endTime = System.nanoTime();
        long convert = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("convert = " + convert);
    }

}
