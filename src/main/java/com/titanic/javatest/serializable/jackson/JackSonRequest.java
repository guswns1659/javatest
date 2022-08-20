package com.titanic.javatest.serializable.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Optional;

public class JackSonRequest {

    private String name;

    public JackSonRequest() {
    }

    public JackSonRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public Optional<String> getMaybeName() {
        return Optional.ofNullable(name);
    }

    @Override
    public String toString() {
        return "JackSonRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}

