package com.java.basics.annotation.impl;

import com.java.basics.annotation.Operation;
import com.java.basics.annotation.custom.Val;
import org.springframework.beans.factory.annotation.Autowired;

public class OperationImpl {
    public Integer add(int a, int b) {
        return null;
    }

    @Autowired
    private Val val;


}
