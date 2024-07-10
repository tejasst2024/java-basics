package com.java.basics.executor.FactoryMain;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class FactoryMain {

    @Autowired
    private CarFactory carFactory;

    public static void main(String[] args) {
        Set<Character> s = new HashSet<>(Arrays.asList( 'a','e','i','o','u','A','E','I','O','U'));
        Map<Integer, Integer> m = new HashMap<>();
        m.put(1, 3);
        int newCounter = m.get(1) + 1;
        m.replace(1,m.get(1));
    }
}
