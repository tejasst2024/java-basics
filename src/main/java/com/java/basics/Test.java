package com.java.basics;

import org.springframework.cglib.core.Local;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.LockSupport;
import java.util.function.Supplier;
import java.util.stream.Stream;

class A {
    static class B {
        void show() {
            System.out.println("in B show");
        }
    }
    public static void main(String[] args) {

        A a = new A();
        B b = new A.B();
        b.show();
    }
}

abstract class C {
     abstract void show();
    public static void main(String[] args) {
        C c = new C(){
            void show() {
                System.out.println("in anonymous show");
            }
        };
        c.show();
    }
}

public class Test {

//    Write a program to calculate the number of days remaining from the expiry date of a product. Derive the date of account deletion which is 18 months added to expiry date. Given Expiry date is 10th Aug 2024


    public static void main(String[] args) {
        LocalDate expiryDate = LocalDate.of(2024,8,10);
        LocalDate today = LocalDate.now();
        LocalDate localDate = expiryDate.minusYears(today.getYear()).minusMonths(today.getMonthValue()).minusDays(today.getDayOfMonth());
        LocalDate deletionDate = expiryDate.plusMonths(18);
        System.out.println("Days remaining: " + localDate.getYear() + " " + localDate.getMonthValue() + " " + localDate.getDayOfMonth());
        System.out.println("Deletion date : " + deletionDate);


        String val = "=te\"st";
        System.out.println(val);
        String s = Stream.of("=","+")
                .filter(val::startsWith)
                .findFirst()
                .map(str -> "\"" + val + "\"")
                .orElse(val);
        System.out.println(s);

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.toString());

    }
}
