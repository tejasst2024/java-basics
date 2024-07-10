package com.java.basics.executor;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class ExecutorUtility {
//    static int i;
//    public static void main(String args) {
////        ExecutorService ex = Executors.newFixedThreadPool(5, Executors.defaultThreadFactory());
////        for (i = 1; i< 25; i++) {
////            ex.execute(() -> {
////                System.out.println(Thread.currentThread().getName());
////                System.out.println("inside for : " + i);
////            });
////        }
////        ex.shutdown();
//
//        int[] a = {2,9,31,-4,24,7};
//        int k = 3;
//        int cSum = 0;
//        int maxSum;
//        for(int i = 0; i < k; i++) {
//            cSum += a[i];
//        }
//        maxSum = cSum;
//        int n = 1;
//        while( n < (a.length - k + 1)) {
//            System.out.println(n);
//            System.out.println(cSum);
//            cSum -= a[n - 1];
//            cSum += a[n + k - 1];
//            System.out.println(cSum);
//            maxSum = Math.max(cSum, maxSum);
//            n++;
//        }
//        System.out.println(maxSum);
//        SortedMap<Map.Entry<Character,Integer>, Object> s = new TreeMap<>(Map.Entry.<Character, Integer>comparingByValue().reversed());
//
//        String va = "leetcode"; //leotcede
//        List<Character> vowels = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
//        Stack<Integer> si = new Stack<>();
//        char[] va1 = va.toCharArray();
//        char[] va2 = Arrays.copyOf(va1, va1.length);
//        for(int i =0; i < va1.length; i++ ) {
//            if (vowels.contains(va1[i])) {
//                si.push(i);
//            }
//        }
//        si.forEach(System.out::println);
//        for(int i =0; i < va.toCharArray().length; i++ ) {
//            if (vowels.contains(va1[i])) {
//                va2[i] = va1[si.pop()];
//                System.out.println(Arrays.toString(va2));
//            }
//        }
//        System.out.println(Arrays.toString(va2));
//        String f = "";
//
////        Arrays.asList(va2).forEach();
//    }
    public int compress(char[] chars) {
    Map<Character, Integer> m =new HashMap<>();
    for(char c : chars) {
        if(m.containsKey(c)) {
            Integer val = m.get(c);
            m.put(c, ++val);
        } else {
            m.put(c, 1);
        }
    }
    System.out.println("val : " + m);
    StringBuilder s = new StringBuilder();
    List<Map.Entry<Character, Integer>> entries = m.entrySet().stream().toList();
    for(int i =0; i < entries.size(); i++) {
        s.append(entries.get(i).getKey());
        chars[i] = entries.get(i).getKey();
        if(entries.get(i).getValue() > 1) {
            s.append(entries.get(i).getValue());
            String s1 = String.valueOf(entries.get(i).getValue());
            int j = 0;
            while(j < s1.length()) {
                chars[i+j+1] = s1.charAt(j);
                j++;
            }
        }
    }
    System.out.println("string : " + s.toString());
    return s.toString().length();
}

    public static void main(String[] args) {
        Integer x = null;
        char[] s =new char[10];
//        char[1] = "90";
        AtomicReference<Integer> y = new AtomicReference<>(10);
        Optional.ofNullable(x).orElse(y.updateAndGet(v -> v + 5));
        System.out.println(y);
        Optional.ofNullable(x).orElseGet(() -> y.updateAndGet(v -> v + 5));
        System.out.println(y);
        boolean zero_1;
    }
    public static void main(String args) {
        List<Person> peopleList = new ArrayList<>(Arrays.asList(Person.builder().age(9).name("9 A").build(), Person.builder().age(14).name("14 B").build(), Person.builder().age(21).name("21 C").build(), Person.builder().age(66).name("66 D").build()));
        Map<String, List<String>> result = new HashMap<>();
//        result.entrySet().forEach((k,v) -> {
//
//        });
        peopleList.forEach(person -> {
            if(person.getAge() >= 8 && person.getAge() <= 12) {
                List<String> names = result.getOrDefault("Children", new ArrayList<>());
                names.add(person.getName());
                result.put("Children", names);
            } else if(person.getAge() >= 13 && person.getAge() <= 19) {
                List<String> names = result.getOrDefault("Teenagers", new ArrayList<>());
                names.add(person.getName());
                result.put("Teenagers", names);
            } else if(person.getAge() >= 20 && person.getAge() <= 64) {
                List<String> names = result.getOrDefault("Adults", new ArrayList<>());
                names.add(person.getName());
                result.put("Adults", names);
            } else if(person.getAge() >= 65) {
                List<String> names = result.getOrDefault("Seniors", new ArrayList<>());
                names.add(person.getName());
                result.put("Seniors", names);
            } else {
                System.out.println("Invalid age : " + person.getAge()  + "for name :" + person.getName());
            }
        });
        result.entrySet().forEach(System.out::println);
    }
}
