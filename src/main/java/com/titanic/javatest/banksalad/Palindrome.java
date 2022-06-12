package com.titanic.javatest.banksalad;

public class Palindrome {
    public boolean solution(String input) {
        // middle 초기화
        int middle = 0;

        // middle 초기화
        if (input.length() % 2 == 0) {
            middle = input.length() / 2 - 1;
        } else {
            middle = input.length() / 2;
        }

        // 회문 판별 로직
        int lastIndex = input.length() - 1;

        for (int index = 0; index <= middle; index++) {
            if (input.charAt(index) != input.charAt(lastIndex - index)) {
                return false;
            }
        }
        return true;
    }
}
