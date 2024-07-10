package com.java.basics.thread;


import java.util.concurrent.*;
import java.util.stream.IntStream;

class AThread implements Runnable {
    private int counter;

    public void increment() {
        counter++;
    }
    public void run() {

        for (int i =0; i < 1000; i++) {
            increment();
        }
    }
    public Integer getCounter() {
        return counter;
    }

     static class InnerClass {
         static void method1() {

        }
    }
}
public class Synchronized {
    public static void main(String[] args) throws InterruptedException {
        AThread obj1 = new AThread();
        AThread obj2 = new AThread();
        Thread t1 = new Thread(() -> {

        });
        AThread.InnerClass.method1();
        t1.start();
        Thread t2 = new Thread(obj1);
        t1.start();
        t2.start();
        t1.join();
        Thread.sleep(10000);
        t2.join();
        Thread.sleep(10000);
        System.out.println(obj1.getCounter());
    }
}
