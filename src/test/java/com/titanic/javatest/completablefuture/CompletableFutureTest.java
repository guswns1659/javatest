package com.titanic.javatest.completablefuture;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

class CompletableFutureTest {
    private static final int sleepA = 3;
    private static final int sleepB = 1;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(4);
    private static final long payAccountId = 1L;

    @Test
    void success() {
        long start = System.currentTimeMillis();

        CompletableFuture.allOf(
                CompletableFuture.supplyAsync(
                        () -> select(payAccountId), executorService
                ),

                CompletableFuture.supplyAsync(
                        () -> select2(payAccountId), executorService
                )
        ).join();

        // send completed kafka
        System.out.println("All elasped : " + ((System.currentTimeMillis() - start) / 1000) + "s");
    }

    @Test
    void fail() {
        try {
            CompletableFuture.allOf(
                    CompletableFuture.supplyAsync(
                            () -> select(payAccountId)
                    ),

                    CompletableFuture.supplyAsync(
                            () -> select2(payAccountId)
                    )
            ).join();
            // 성공 메세지 produce

        } catch (CompletionException | CancellationException e) {
            // logging or 다른 작업?

        }
    }

    private long selectWithTimeout(long payAccountId) {

        try {
            Thread.sleep(sleepA * 1000);
            throw new TimeoutException("timeout");
        } catch (Exception e) {
        }
        return payAccountId;
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
