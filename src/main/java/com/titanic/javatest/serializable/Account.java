package com.titanic.javatest.serializable;


import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class Account implements Serializable {

    private transient String name;
    private String phoneNumber;
    private int age;

    @Builder
    public Account(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public static Account of(String name, String phoneNumber, int age) {
        return Account.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .age(age)
                .build();
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
