package com.java.basics.collection;

import java.util.*;

public abstract class UsingExistingData {

    protected abstract void method1();

    void method2() {

    }

    public static void main(String[] args) {
        Set<Integer> s2 = new HashSet<>();
        Stack<Integer> s = new Stack<>();
        String[] s1 = new String[]{"Apple","Orange"};
        List<String> fruits =  Arrays.stream(s1).toList();
        List<String> fruits1 = new ArrayList<>(fruits);
//        Lists.newArrayList Google guava lib - import com.google.common.collect.Lists;

        List<String> names = new ArrayList<>(Arrays.asList("Clementine", "Duran", "Mike"));
        names.forEach(System.out::println);
        names.parallelStream().forEach(System.out::println);

        List<String> anEmptyList = Collections.emptyList();
//        anEmptyList.add("e"); // throws java.lang.UnsupportedOperationException emptylist is immutable

        System.out.println(names.size());
        List<String> names1 = names.subList(0,3);
        names1.add("Bose");
        names.forEach(System.out::println);
        Optional<String> reduce = names.stream().reduce(String::concat);
        // If you're creating a sublist from a list, then any modifications made to sublist will affect the main list. This is called Backed collections.


    }
}
