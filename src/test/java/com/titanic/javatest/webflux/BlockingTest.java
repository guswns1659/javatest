package com.titanic.javatest.webflux;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;


@SpringBootTest(webEnvironment = DEFINED_PORT, properties = "8080")
public class BlockingTest {

    private static final String THREE_SECOND_URL = "http://localhost:8080/3second";
    private static final int LOOP_COUNT = 100;

    private final WebClient webClient = WebClient.create();
    private final CountDownLatch count = new CountDownLatch(LOOP_COUNT);
    private Logger log = LoggerFactory.getLogger(BlockingTest.class);

    @BeforeEach
    void setUp() {
        System.setProperty("reactor.netty.ioWorkerCount", "1");
    }

    @DisplayName("Blocking 테스트")
    @Test
    void blocking() {
        final RestTemplate restTemplate = new RestTemplate();

        final StopWatch jackWatch = new StopWatch();
        jackWatch.start();

        for (int loop = 0; loop < 3; loop++) {
            final ResponseEntity<String> response =
                    restTemplate.exchange(THREE_SECOND_URL, HttpMethod.GET, HttpEntity.EMPTY, String.class);
            assertThat(response.getBody()).contains("success");
        }

        jackWatch.stop();

        log.info("TotalTime : {}", jackWatch.getTotalTimeSeconds());
    }

    @DisplayName("Non-Blocking 테스트")
    @Test
    void nonBlocking() {

    }
}
