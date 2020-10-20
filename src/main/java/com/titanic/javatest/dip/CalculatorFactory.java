package com.titanic.javatest.dip;

public interface CalculatorFactory {
    Calculator getCalculator(String type);

    static DefaultCalculatorFactory instance() {
        return new DefaultCalculatorFactory();
    }
}
