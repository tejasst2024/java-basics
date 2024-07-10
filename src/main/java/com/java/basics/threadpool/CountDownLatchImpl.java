package com.java.basics.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CountDownLatchImpl {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(8);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, queue);
        IntStream.range(0, 10).forEach(index -> {
            threadPoolExecutor.execute(() -> {
                System.out.println("count index : " +  index);
                try {
                    countDownLatch.countDown();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });
        countDownLatch.await();
        System.out.println(LocalDateTime.now());
        threadPoolExecutor.shutdown();
    }
}
