package com.java.basics.test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        int[] list = {2,5,4,5,6,5,11};
        // 1. most repeated w stream
        // 2. remove duplicate w/o stream
        Map<Integer, Long> map = Arrays.stream(list).boxed().collect(Collectors.groupingBy(val -> val, Collectors.counting()));
        System.out.println(map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get());
        List<Integer> li = new ArrayList<>();
        for (int i =0; i < list.length;i++) {
            if(map.get(list[i]) == 1) {
                li.add(list[i]);
            }
        }
        System.out.println(li);


        List<Integer> list1 = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3,4,5));
        for(Integer val : list1) {
            list1.add(6);
        }
        System.out.println(list1);
        list1.parallelStream().collect(Collectors.toList());
    }
}
