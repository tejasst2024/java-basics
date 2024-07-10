package com.java.basics.list;

import org.apache.logging.log4j.util.PropertySource;

import java.util.*;
import java.util.function.Function;

public class ListUses {

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3,4,5);
        List<Integer> l2 = Arrays.asList(1,2,3);
        List<Integer> l3 = new ArrayList<>(l1);
        l3.retainAll(l2);
        l3.forEach(System.out::println);

        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1 % 10, o2 % 10);
            }
        };
        List<Integer> li = new ArrayList<>();
        li.add(12);
        li.add(4);
        li.add(21);
        li.add(33);
        li.sort(cmp);
//        li.sort(Comparator.comparing((e) -> e % 10));
        System.out.println(li);

        Function<String, String> s = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };
        Comparator<String> comparator = Comparator.naturalOrder();
        Comparator<Integer> comparator1 = Comparator.reverseOrder();
        List<String> stringList = new ArrayList<>();
        stringList.add("123");
        stringList.add("1234");
        stringList.add("12");
        stringList.add("1");
        stringList.add("12345");
        stringList.sort(comparator);
        System.out.println(stringList);
        ".".compareTo("123");

    }
}
