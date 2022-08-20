package com.titanic.javatest.serializable.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Optional;

public class JackSonResponse {

    private String result;

    public JackSonResponse() {
    }

    public JackSonResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @JsonIgnore
    public Optional<String> getMaybeResult() {
        return Optional.of("maybeResult");
    }

    @Override
    public String toString() {
        return "JackSonResponse{" +
                "result='" + result + '\'' +
                '}';
    }
}
