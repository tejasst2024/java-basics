package com.java.basics.annotation.meta.annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

interface X{
    boolean y(boolean x);
}

public class MetaAnnotationUses {


    public static void main(String[] args) {
        List<String> x = new ArrayList<>();
        X xnew = new X() {
            @Override
            public boolean y(boolean x) {
                return false;
            }
        };
        Predicate<String> predicate = (we) -> (xnew.y(true));
        x.stream().filter(predicate.and(y -> y.equals("hello")));
        x.stream().filter(y->Predicate.isEqual(y).test(y));

    }
}
