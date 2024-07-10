package com.java.basics.collection;

import java.util.Iterator;
import java.util.LinkedList;

public class AddRemove {

    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Strawberry");

        for (int i = (fruits.size() - 1); i >=0; i--) {
            System.out.println (fruits.get(i));
            if ("Apple".equals(fruits.get(i))) {
                fruits.remove(i);
            }
        }

        for(int i=0; i<fruits.size(); i++) {
            System.out.println(i + fruits.get(i));
            if ("Apple".equals(fruits.get(i))) {
                fruits.remove(i);
            }
        }

        for (String fruit : fruits) {
            System.out.println(fruit);
            if ("Apple".equals(fruit)) {
                fruits.remove(fruit);
            }
        }

        Iterator<String> stringIterator = fruits.listIterator();
//        fruits.add("Watermelon"); throws java.util.ConcurrentModificationException
        while (stringIterator.hasNext()) {
            String fruit = stringIterator.next();
            if ("Apple".equals(fruit)) {
                stringIterator.remove();
            }
        }


        fruits.removeIf("Apple"::equals);

    }
}
