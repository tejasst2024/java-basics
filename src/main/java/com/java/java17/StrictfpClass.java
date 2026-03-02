package com.java.java17;

import java.util.random.RandomGeneratorFactory;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class StrictfpClass {
    public static LongStream getPseudoInts(String algorithm, int streamSize) {
        // returns an IntStream with size @streamSize of random numbers generated using the @algorithm
        // where the lower bound is 0 and the upper is 100 (exclusive)

        return RandomGeneratorFactory.all().flatMapToInt(x -> x.create().ints(streamSize)).asLongStream();
    }

    public static void main(String[] args) {

        double num1 = 10e+10;
        double num2 = 6e+08;
        // Returning the sum
        System.out.println(num1 + num2);
        Integer obj = 10;
        switch (obj) {
            case 1 -> System.out.println(obj);
            case 2 -> System.out.println(obj);
        }
        System.out.println(getPseudoInts("", 10).boxed().collect(Collectors.toList()));
    }
}
