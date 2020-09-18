package com.titanic.javatest.serializable;

import java.io.Serializable;

public class JackSingleton implements Serializable {
    private static final JackSingleton INSTANCE = new JackSingleton();

    public JackSingleton() {
    }

    public static JackSingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
