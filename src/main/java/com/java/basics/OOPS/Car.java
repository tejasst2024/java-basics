package com.java.basics.OOPS;

import java.util.Objects;

public class Car {
    private String color;
    private String type;
    private int size;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return size == car.size && type.equals(car.type);
    }
    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        c1.color = "red";
        c1.type = "sedan";
        c1.size = 5;
        Car c2 = new Car();
        c2.color = "red";
        c2.type = "sedan";
        c2.size = 6;
        System.out.println(c1.equals(c2));
        System.out.println(c1.hashCode() + " " + c2.hashCode());
    }
}
