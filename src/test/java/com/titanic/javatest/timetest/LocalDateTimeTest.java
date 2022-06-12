package com.titanic.javatest.timetest;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;

class LocalDateTimeTest {

    @Test
    void epochMilli() {
        long epochMilli = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(epochMilli);
        assertThat(String.valueOf(epochMilli).length()).isEqualTo(13);

    }
}
