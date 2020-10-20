package com.titanic.javatest.dip;

public class SubCalculator implements Calculator {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}
