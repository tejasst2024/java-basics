package com.java.basics.collection;

import java.util.*;

public class ParallelStream {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Clementine", "Duran", "Mike"));
        names.parallelStream().forEach(System.out::println);
        // Ref: https://www.baeldung.com/java-parallelstream-vs-stream-parallel#:~:text=A%20parallel%20stream%20allows%20us,to%20form%20the%20final%20output.
        // https://www.baeldung.com/java-when-to-use-parallel-stream
        // Parallel streams should be used when wanted to use multiple core to process

        String s = "testString";
        String newString = s.replace("test", "original");
//        newString = s;
        newString = new String(s);
        String m;
        m = "qwerty";
        System.out.println(newString.equals("testString"));
        System.out.println(s.hashCode() + " " + newString.hashCode());
        final StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        final StringBuffer sb1 = sb;
//        sb1 = new StringBuffer();
//        sb = new StringBuffer("test");
        System.out.println(sb);

    }

}
