package com.java.basics.statics;

import lombok.ToString;

class Example {
    static {
        System.out.println("in the static block of example class");
    }
}
public class Static {
    private Integer rollNo;
    private String name;
    private static Integer age;

//    static {
//        age = 21;
//        System.out.println("in static block : " + age);
//    }
    public Static() {
        System.out.println("in the constructor : " + age);
    }

    private void show() {
        System.out.println("rNo : " + rollNo + ", name : " + name + ", age : " + age );
    }
    private static void showStatic(Static s) {
        System.out.println("rNo : " + s.rollNo + ", name : " + s.name + ", age : " + age );
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.java.basics.statics.Example");
//        Static s = new Static();
//        s.rollNo = 21;
//        s.name = "Ram";
//        s.age = 13;
//
//        Static s1 = new Static();
//        s1.rollNo = 22;
//        s1.name = "Varun";
//        s1.age = 14;
//
//        System.out.println(s.age);
//        System.out.println(s1.age);
//
//        s1.show();
//        Static.showStatic(s1);
    }
}
