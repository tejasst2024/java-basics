package com.java.basics.OOPS;

import java.lang.*;


class Sample {
    private Integer age;

    public Sample() {
        System.out.println("in Sample()");
    }
    public Sample(int age) {
        System.out.println("in Sample()");
    }
}
class B extends Sample{
    public B() {
        this(5);
        System.out.println("in B()");
    }
    public B(int x) {
        System.out.println("in B() age");
    }
}
public class ThisKeyword {
    public static void main(String[] args) {
        B b =  new B();
    }
}
