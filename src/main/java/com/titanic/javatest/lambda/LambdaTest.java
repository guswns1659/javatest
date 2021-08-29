package com.titanic.javatest.lambda;

import java.io.BufferedInputStream;
import java.lang.invoke.CallSite;
import java.util.Arrays;
import java.util.Scanner;

public class LambdaTest {

    public static void main(String[] args) {
        LambdaObject lambdaObject = new LambdaObject();
        System.out.println(lambdaObject.checkLength("Red", "Green", "Blue"));
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
    }

    static class LambdaObject {

        public long checkLength(String color1, String color2, String color3) {
            return Arrays.asList(color1, color2, color3)
                .stream().filter(c -> c.length() > 3).count();
        }
    }
}
