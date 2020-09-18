package com.titanic.javatest.serializable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

public class SerializableTest {

    private Serializer serializer;
    private static final String serializedResult = "rO0ABXNyACljb20udGl0YW5pYy5qYXZhdGVzdC5zZXJpYWxpemFibGUuQWNjb3VudAAAAAAAAAABAgACSQADYWdlTAALcGhvbmVOdW1iZXJ0ABJMamF2YS9sYW5nL1N0cmluZzt4cAAAABx0AA0wMTAtNzcyMC03OTU0";

    @BeforeEach
    void setUp() {
        this.serializer = new Serializer();
    }

    @Test
    void serialize를_테스트한다() {
        // given
        Account account = Account.of("jack", "010-7720-7954", 28);

        // when, then
        assertThat(serializer.serialize(account)).isEqualTo(serializedResult);
    }

    @Test
    void deserialize를_테스트한다() {

        // when
        Account deserializeAccount = (Account) serializer.deserialize(serializedResult);
        assertThat(deserializeAccount).isInstanceOf(Account.class);
        System.out.println(deserializeAccount);
    }
}
