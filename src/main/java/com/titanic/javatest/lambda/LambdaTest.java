package com.titanic.javatest.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1 ,2, 3);
        list.stream().filter(integer -> integer > 2).forEach(System.out::println);
    }

}
