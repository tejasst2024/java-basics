package com.java.basics.map;

import java.util.*;
import java.util.stream.Collectors;

public class MapUses {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("john", 20);
        map.put("paul", 30);
        map.put("peter", 40);
        map.replaceAll((key,value)->value+10);
        map.entrySet().forEach(System.out::println);
        map.replace("peter", 60);
        map.entrySet().forEach(System.out::println);
        map.remove("peter", 50);
        map.entrySet().forEach(System.out::println);
        map.replace("peter", 70);
        map.entrySet().forEach(System.out::println);
        map.putIfAbsent("peter",110);
        map.entrySet().forEach(System.out::println);
        map.computeIfAbsent("reddy", s -> s.toCharArray().length + 10);
        map.entrySet().forEach(System.out::println);
        Integer reddy = map.computeIfPresent("reddy", (k, v) -> v+24);
        System.out.println(reddy);

        for(String key: map.keySet()) {

        }
        for(Integer val : map.values()) {

        }
        for(Map.Entry<String, Integer> m : map.entrySet()) {

        }
        for(Map.Entry<String, Integer> m : map.entrySet()) {
            map.merge(m.getKey(), m.getValue(), Integer::sum);
        }
        map.entrySet().forEach(System.out::println);
        map.put(null, 12);
        System.out.println(map.get(null));
        List<Integer> x = new ArrayList<>(){{add(10); add(10);}};
        LinkedHashMap s = new LinkedHashMap();


        Map<Integer, String> map1 = new HashMap<>();
        map1.put(4, "abc");
        map1.put(1, "abc");
        map1.put(2, "aba");
        map1.put(3, "abb");
        List<Map.Entry<Integer, String>> val = map1.entrySet().stream().sorted(Map.Entry.<Integer, String>comparingByValue().reversed()).toList();
        val.forEach((k) -> System.out.println(k.getValue()));
        System.out.println("oajnoaskasd");
        System.out.println(map1.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()));

        String st = "tree";
        String t = "tree";
        String u = new String("tree");
        String v = new String(st);
        String w = new String(v).intern();
        System.out.println(st == w);
    }
}
