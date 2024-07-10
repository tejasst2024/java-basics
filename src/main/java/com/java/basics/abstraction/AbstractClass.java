package com.java.basics.abstraction;


class DoubleWriter extends Abstract {
    @Override
    Double writer(Number number) {
        return (double)number;
    }
}
class IntegerWriter extends Abstract {
    @Override
    Integer writer(Number number) {
        return (int)number;
    }
}
abstract class Abstract {
    abstract Number writer(Number number);
}
public class AbstractClass {
    public static void main(String[] args) {
        System.out.println("abstract class");
    }
}
