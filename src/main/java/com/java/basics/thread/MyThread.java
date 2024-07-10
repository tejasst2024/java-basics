package com.java.basics.thread;

import com.java.basics.collection.UsingExistingData;

import java.util.*;
import java.util.stream.Collectors;

class Sender {
    public void send(String msg)
    {
        System.out.println("Sending\t" + msg);
        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
}

// Class for send a message using Threads
class ThreadedSend extends Thread {
    private String msg;
    Sender sender;

    // Receives a message object and a string
    // message to be sent
    ThreadedSend(String m, Sender obj)
    {
        msg = m;
        sender = obj;
    }

    public void run()
    {
        // Only one thread can send a message
        // at a time.
        synchronized (sender)
        {
            // synchronizing the send object
            sender.send(msg);
        }
    }
}
public class MyThread extends Thread implements Runnable{

    public void run() {
        Thread.currentThread().interrupt();
        System.out.println("This is running " + this);
        System.out.println(Thread.activeCount() + " " + Thread.interrupted());
    }



    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        Thread t1 = new Thread(new MyThread());
//        System.out.println(t1);
//        Thread t2 = Thread.currentThread();
//        MyThread t3 = new MyThread();
//        System.out.println(t2);
//        StringBuilder s = new StringBuilder("testString");
//        t1.start();
//        System.out.println(t3.getState());
//        t3.start();
//        System.out.println(t3.getState());
//        t3.interrupt();
//        System.out.println(t3.getState());
////        Thread.currentThread().wait(10);
//        System.out.println(t2.getClass() + " String " + t1.getClass());
//        Integer i = 10;
//        Long l = i.longValue();
        Sender sender = new Sender();
        UsingExistingData u =  new UsingExistingData() {
            @Override
            protected void method1() {

            }
        };
        ThreadedSend threadedSend1 = new ThreadedSend("hi", sender);
        ThreadedSend threadedSend2 = new ThreadedSend("bye", sender);
        threadedSend1.start();
        threadedSend2.start();
        threadedSend1.join();
        threadedSend2.join();
        Map<Integer, Integer> map = new HashMap<>();
        String s = "tree";
        char[] arr = s.toCharArray();
        for(char c : arr) {
            Integer val = (int) c;
            if(map.containsKey(val)) {
                Integer count = map.get(val);
                map.put(val, count + 1);
            } else {
                map.put(val, 1);
            }
        }

        Map<Integer, Integer> result = map.entrySet().stream().sorted().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println(result);
    }
}
