package com.java.java17.sealedclass;

import javassist.tools.reflect.Reflection;

final class Rectangle extends Shape {
    Integer getSides() {
        return 4;
    }
}

non-sealed class Triangle extends Shape {
    Integer getSides() {
        return 3;
    }
}

sealed class Square extends Shape permits Circle {
    Integer getSides() {
        return 0;
    }
}

final class Circle extends Square {
    Integer getSides() {
        return 0;
    }
}

class MiniTriangle extends Triangle {
    Integer getSides() {
        return 3;
    }
}

class NoShape extends MiniTriangle {
    Integer getSides() {
        return 3;
    }
}

public sealed class Shape permits Rectangle, Square, Triangle {
    public static void main(String[] args) {
        Rectangle s1 = new Rectangle();
        System.out.println(s1.getSides());
        MiniTriangle m1 = new MiniTriangle();
        System.out.println(m1.getSides());
        Triangle t1 = new Triangle();
        System.out.println(t1.getSides());
    }
}
