package com.titanic.javatest.statictest;

import org.junit.jupiter.api.Test;

class StaticBlockTest {

    @Test
    void staticBlockTest() {
        System.out.println(StaticBlockUtils.showName());
    }
}

class StaticBlockUtils {
    private static String name = "FIRST";

    static {
        System.out.println(name);
        name="SECOND";
    }

    public static String showName() {
        return name;
    }
}
