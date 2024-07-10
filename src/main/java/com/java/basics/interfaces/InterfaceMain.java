package com.java.basics.interfaces;

import java.util.ArrayList;
import java.util.List;

interface B {
    void foo();
}
interface A {
    void foo();
}
public class InterfaceMain implements A, B {
    public static void main(String[] args) {
        List<Integer> val  = new ArrayList<>();
        val.set(0, 24);
        val.set(4, 24);
        System.out.println(val);
    }
    @Override
    public void foo() {

    }
}
