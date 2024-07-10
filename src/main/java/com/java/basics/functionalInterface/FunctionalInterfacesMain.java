package com.java.basics.functionalInterface;

import java.util.*;
import java.util.concurrent.Flow;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FunctionalInterfacesMain {

    public static void main(String[] args) {
        Predicate<String> predicate = Predicate.isEqual("test1");
        Predicate<String> predicate1 = predicate.and(x -> x.length() == 5);
        System.out.println(predicate.test("test1"));
        System.out.println(predicate1.test("test1"));

        Consumer<String> consumer = System.out::println;
        consumer.accept("Test12344");
        Consumer<String> consumer1 = System.out::print;
        consumer1.andThen(consumer);

        Function<Boolean, String> val = Object::toString;
        Comparator<Boolean> comparable = Comparator.comparing(val);

        Supplier<String> s1 = String::new;

        Map<String, Integer> map = new HashMap<>();
        map.put("c", 21);
        map.put("q", 12);
        map.put("a", 17);
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEachOrdered(System.out::println);

    }
}


