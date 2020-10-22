package com.titanic.javatest.designPattern;

public class Singleton {

    private static volatile Singleton singletonObject = new Singleton();

    private Singleton() {};

    public static Singleton getSingletonObject() {
        return singletonObject;
    }
}
