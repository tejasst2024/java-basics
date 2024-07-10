package com.java.basics.annotation;

@FunctionalInterface
public interface Operation extends OperationDefault{
    Integer add(int a, int b);

}
