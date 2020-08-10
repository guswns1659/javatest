package com.titanic.javatest.algorithm;

import java.util.Arrays;

public class Recursion {

    public int sumList(int[] numbers) {
        if (numbers.length <= 1) {
            return numbers[0];
        }
        return numbers[0] + sumList(Arrays.copyOfRange(numbers, 1, numbers.length));
    }
}
