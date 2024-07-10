package com.java.basics.annotation;

public interface OperationDefault {

    default Integer add() {
      return 10;
    };
}
