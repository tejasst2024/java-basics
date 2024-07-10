package com.java.basics.annotation;

public class OperationUses {

    public static void main(String[] args) {
        Operation operation = Integer::sum;
        Integer add = operation.add(10, 5);
        System.out.println("testttt : " + add);
        System.out.println(checkAndAdd(operation, 12, 10));
        operation = Integer::compare;
    }

    public static Integer checkAndAdd(Operation operation, Integer a, Integer b) {
        return operation.add(a,b);
    }
}
