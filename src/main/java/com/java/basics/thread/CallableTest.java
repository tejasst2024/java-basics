package com.java.basics.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

public class CallableTest implements Callable<String> {
    public static int counter;
    @Override
    public String call() throws Exception {
        counter = counter + 1;
        return null;
    }

    public static void main(String[] args) throws Exception {
        CallableTest callableTest = new CallableTest();
        CallableTest callableTest1 = new CallableTest();
        ExecutorService executorService = new ForkJoinPool();

        for (int i =0 ; i< 1000; i++) {
            callableTest.call();
        }
        for (int i =0 ; i< 1000; i++) {
            callableTest1.call();
        }
        System.out.println(counter);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
