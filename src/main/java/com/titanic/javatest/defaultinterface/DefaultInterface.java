package com.titanic.javatest.defaultinterface;

public interface DefaultInterface {
    String bye();
    default String hello() {
        return "Hello from A interface";
    }

}
