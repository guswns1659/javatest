package com.titanic.javatest.algorithm;

import java.util.Arrays;

public class Recursion {

    public int sumList(int[] numbers) {
        if (numbers.length <= 1) {
            return numbers[0];
        }
        return numbers[0] + sumList(Arrays.copyOfRange(numbers, 1, numbers.length));
    }

    public boolean palindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }

        if (word.charAt(0) == word.charAt(word.length()-1)) {
            return palindrome(word.substring(1, word.length() - 1));
        }
        return false;
    }
}
