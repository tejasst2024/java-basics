package com.java.basics.threadpool;

import org.apache.logging.log4j.util.PropertySource;
//import org.springframework.scheduling.config.DelayedTask;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ForkJoinPoolImpl {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool(2);
        ForkJoinPool forkJoinPool = new ForkJoinPool(1);
        ThreadFactory defaultThreadFactory =  Executors.defaultThreadFactory();
        BlockingQueue<ScheduledFuture<Integer>> integers = new DelayQueue<>();

        Executors.newSingleThreadExecutor(); // Uses a single pre-defined immutable thread
        Executors.newWorkStealingPool();     // Folk join pool -> CompletableFuture.runAsync()
        Executors.defaultThreadFactory();   // uses current thread group to create newer threads
        ExecutorService executorService = Executors.newCachedThreadPool();// creates new threads whenever required, terminates thread after 60s
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(()-> System.out.println(123), 12,TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(()-> System.out.println(123), 4, 20, TimeUnit.SECONDS);
        Executors.newSingleThreadScheduledExecutor();
        Executors.newFixedThreadPool(4);

        BlockingQueue<Integer> queue = new SynchronousQueue<>();
//        System.out.println(queue.add(12));
        queue.size();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        defaultThreadFactory.newThread(() -> {
            try {
                System.out.println(queue);
                Thread.sleep(1000);
                queue.put(12);
                countDownLatch.countDown();
                System.out.println(queue);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
//        countDownLatch.await();
        defaultThreadFactory.newThread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(queue.take());
                Thread.sleep(1000);
                System.out.println(queue);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int  i =0; i < 10; i++) {
            int finalI = i;
            callables.add(() -> finalI);
        }
        executorService1.invokeAll(callables);

//        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
//        List<Callable<Integer>> callables = new ArrayList<>();
//
        for (int  i =0; i < 10; i++) {
            int finalI = i;
            callables.add(() -> finalI);
        }
        executorService1.invokeAll(callables);
        ExecutorService cachedThreadFactory = Executors.newCachedThreadPool();
        cachedThreadFactory.invokeAll(callables);
        System.out.println(callables);
        cachedThreadFactory.shutdown();

//        System.out.println(queue.offer(13));
//        System.out.println(queue);
//        queue.take();
//        System.out.println(queue);
//        queue.put(14);
//        System.out.println(queue);


//        ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();

    }
}
