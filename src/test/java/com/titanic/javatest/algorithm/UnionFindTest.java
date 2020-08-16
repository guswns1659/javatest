package com.titanic.javatest.algorithm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UnionFindTest {

    @ParameterizedTest
    @CsvSource({"5"})
    void UnionFind알고리즘을_테스트한다(int number) {
        System.out.println(UnionFind.test(number));
    }
}
