package com.titanic.javatest.completablefuture;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CompletableFutureTest {
    private static final int sleepA = 3;
    private static final int sleepB = 1;

    @Test
    void single() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        long payAccountId = 1L;
        long start = System.currentTimeMillis();

        CompletableFuture.allOf(
                CompletableFuture.supplyAsync(
                        () -> select(payAccountId), executorService
                ).thenAcceptAsync(this::insert),

                CompletableFuture.supplyAsync(
                        () -> select2(payAccountId), executorService
                ).thenAcceptAsync(this::insert2)
        ).join();
        System.out.println("All elasped : " + ((System.currentTimeMillis() - start) / 1000) + "s");
    }

    private Long select(long payAccountId) {
        // DB에서 select
//        int sleep = new Random().nextInt(3);
        int sleep = sleepA;
        try {
            Thread.sleep(sleep * 1000);
        } catch (Exception e) {
        }
        System.out.println("select1 done");
        System.out.println("thread : " + Thread.currentThread());

        return payAccountId;
    }

    private Long select2(long payAccountId) {
        // DB에서 select
//        int sleep = new Random().nextInt(3);
        int sleep = sleepB;
        try {
            Thread.sleep(sleep * 1000);
        } catch (Exception e) {
        }
        System.out.println("select2 done");
        System.out.println("thread : " + Thread.currentThread());

        return payAccountId;
    }

    private void insert(long payAccountId) {
        // DB에 insert
//        int sleep = new Random().nextInt(3);
        int sleep = sleepA;
        try {
            Thread.sleep(sleep * 1000);
        } catch (Exception e) {
        }
        System.out.println("insert1");
    }

    private void insert2(long payAccountId) {
        // DB에 insert
//        int sleep = new Random().nextInt(3);
        int sleep = sleepB;
        try {
            Thread.sleep(sleep * 1000);
        } catch (Exception e) {
        }
        System.out.println("insert2");
    }
}
