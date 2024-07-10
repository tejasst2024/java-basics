package com.java.basics.queue;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public final class QueueUses {
    public static void main(String[] args) {
        java.util.PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>();
        priorityQueue.addAll(Arrays.asList(1,3,7,2,5,4));
        System.out.println(priorityQueue);
        priorityQueue.remove();
        System.out.println(priorityQueue);

        Deque<Integer> deque = new LinkedList<>();
        BlockingDeque<Integer> blockingDeque ;

        Queue<Integer> integers = new LinkedBlockingDeque<>(1);
        integers.offer(10);
        System.out.println(integers.offer(12));
//        System.out.println(integers.add(12));
        System.out.println(integers);

        Queue<Integer> integers1;
    }
}
