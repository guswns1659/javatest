package com.titanic.javatest.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);
        System.out.println("===================");
        // 해당 클래스의 애노테이션만 가져오고 싶을 때
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);
    }
}
