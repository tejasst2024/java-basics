package com.java.basics.set;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@SuppressWarnings({"testWarning", })
public class SetUses {
    public static void main(String[] args) {
        Set<String> ts = new TreeSet<>(String::compareTo);
        Set<Integer> si = Set.of(1,2,3,4,5);
        AtomicInteger sum = new AtomicInteger();
        si.forEach(sum::addAndGet);
    }
}
