package com.titanic.javatest.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {
        LambdaObject lambdaObject = new LambdaObject();
        System.out.println(lambdaObject.lengthyColors("Red", "Green", "Blue"));
    }

    static class LambdaObject {

        public long lengthyColors(String color1, String color2, String color3) {
            long lengthyColors = Arrays.asList(color1, color2, color3)
                .stream().filter(c -> c.length() > 3).count();
            return lengthyColors;
        }
    }
}
