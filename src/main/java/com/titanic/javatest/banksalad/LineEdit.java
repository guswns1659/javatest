package com.titanic.javatest.banksalad;

public class LineEdit {
    public String lineEdit(String input, int length) {
        // 예외처리
        if (input == null || input.length() <= length) {
            return input;
        }

        for (int index = length - 1; index > -1; index--) {
            if (input.charAt(index) == ' ') {
                return input.substring(0, index) + "\n" + lineEdit(input.substring(index+1).trim(), length);
            }
        }

        return input.substring(0, length) + "\n" + lineEdit(input.substring(length).trim(), length);
    }
}
