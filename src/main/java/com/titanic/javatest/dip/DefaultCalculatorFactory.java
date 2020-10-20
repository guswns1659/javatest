package com.titanic.javatest.dip;

public class DefaultCalculatorFactory implements CalculatorFactory {
    @Override
    public Calculator getCalculator(String type) {
        if (type.equals("sum")) {
            return new SumCalculator();
        } else if (type.equals("sub")) {
            return new SubCalculator();
        }
        return new multiCalculator();
    }
}
