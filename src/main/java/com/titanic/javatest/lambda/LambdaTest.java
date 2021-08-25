package com.titanic.javatest.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {
        long lengthyColors = Arrays.asList("Red", "Green", "Blue")
            .stream().filter(c -> c.length() > 3).count();

    }
}
