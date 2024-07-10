package com.java.basics.thread;

import ch.qos.logback.core.joran.conditional.ThenAction;

public class SynchronizedBlock {

    private static int counter;
    private static int counterShow;
    private static int counterPrint;

    static {
        System.out.println("in static block");
    }

    static void show() {
        synchronized (SynchronizedBlock.class) {
            counter = counter +1;
            counterShow = counterShow + 1;
//            System.out.println("in show synchronized block");
        }
    }

     static void print() {
          {
            counter = counter + 1;
            counterPrint = counterPrint + 1;
//            System.out.println("in print synchronized block");
        }
    }

    public int getCounter() {
        return counter;
    }

    public int getCounterPrint() {
        return counterPrint;
    }

    public int getCounterShow() {
        return counterShow;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlock synchronizedBlock = new SynchronizedBlock();
        Thread t1 = new Thread(() -> {
            for (int i =0; i< 1000; i++) {
                SynchronizedBlock.show();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i =0; i< 1000; i++) {
                SynchronizedBlock.print();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        t1.wait();
        System.out.println(synchronizedBlock.getCounter());
        System.out.println(synchronizedBlock.getCounterShow());
        System.out.println(synchronizedBlock.getCounterPrint());

    }
}


