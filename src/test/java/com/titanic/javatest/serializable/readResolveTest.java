package com.titanic.javatest.serializable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class readResolveTest {

    private JackSingleton jackSingleton;
    private Serializer serializer;

    @BeforeEach
    void setUp() {
        this.jackSingleton = JackSingleton.getInstance();
        this.serializer = new Serializer();
    }

    @Test
    void 일반직렬화를_테스트한다() throws Exception {
        // when
        String serialized = serializer.serialize(jackSingleton);
        JackSingleton deserialized = (JackSingleton) serializer.deserialize(serialized);

        // then
        assertThat(deserialized).isSameAs(jackSingleton);
        assertThat(deserialized).isEqualTo(jackSingleton);
    }

    @Test
    void readResolve를_테스트한다() throws Exception {
        // when
        String serialized = serializer.serialize(jackSingleton);
        JackSingleton deserialized = (JackSingleton) serializer.deserialize(serialized);

        // then
        assertThat(deserialized).isSameAs(jackSingleton);
        assertThat(deserialized).isEqualTo(jackSingleton);
    }
}
