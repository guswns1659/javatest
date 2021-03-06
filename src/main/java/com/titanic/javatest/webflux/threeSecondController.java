package com.titanic.javatest.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class threeSecondController {

    private final AtomicInteger atomicInteger = new AtomicInteger();

    @GetMapping("/3second")
    public String threeSecond() throws InterruptedException {
        Thread.sleep(3000);
        // 요청올 때마다 1씩 추가
        return "success - " + atomicInteger.incrementAndGet();
    }
}
