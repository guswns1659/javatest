package com.titanic.javatest.designPattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JackSingletonTest {

    @DisplayName("싱글턴 테스트")
    @Test
    public void getSingletonObject() {
        Singleton singleObject1 = Singleton.getSingletonObject();
        Singleton singleObject2 = Singleton.getSingletonObject();
        System.out.println(singleObject1 == singleObject2);
    }
}