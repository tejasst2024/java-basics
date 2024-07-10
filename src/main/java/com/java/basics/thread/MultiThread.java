package com.java.basics.thread;


class A extends Thread{
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class MultiThread {

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        B b = new B();
        a.start();
        Thread.sleep(2);
        Thread.yield();
        b.start();
    }
}
