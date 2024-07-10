package com.java.basics.OOPS;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }

    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Person p1 = new Person("John", 25, "male");
        Person p2 = new Person("John", 25, "female");

        map.put(p1, "Person1");
        System.out.println(p1.hashCode() + " " + p2.hashCode());
        System.out.println("Retrieved: " + map.get(p2)); // This should print "Person1" if hashcode is generated properly
        System.out.println(p1.equals(p2));
    }
}