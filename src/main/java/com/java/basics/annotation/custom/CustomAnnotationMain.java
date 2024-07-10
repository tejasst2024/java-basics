package com.java.basics.annotation.custom;

import lombok.Getter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class CustomAnnotationMain {

    public static void main(String[] args) throws Exception {
        Student student = new Student();
        student.setName("tejas");
        student.setRno(1234);
        System.out.println(jsonConverter(student));
    }

    public static void checkIfSerializable(Object object) throws Exception {
        if (Objects.isNull(object)) {
            throw new Exception("The object to serialize is null");
        }

        Class<?> class1 = object.getClass();
        if (!class1.isAnnotationPresent(JsonSerializable.class)) {
            throw new Exception("The class "
                    + class1.getSimpleName()
                    + " is not annotated with JsonSerializable");
        }
    }

    public static void initialize(Object object) throws Exception {
        Class<?> class2 = object.getClass();
        for (Method method : class2.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    public static String convertToJsonString(Object object) throws Exception {
        Class<?> class3 = object.getClass();
        Map<String, Object> keyValMap = new HashMap<>();
        for (Field field : class3.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                keyValMap.putIfAbsent(field.getName(), field.get(object));
            }
        }
        String jsonString = keyValMap.entrySet().stream().map(entry -> "\"" + entry.getKey() + "\"" + ":" + "\"" + entry.getValue() + "\"").collect(Collectors.joining(","));
        return "{" + jsonString  + "}";
    }

    public static String jsonConverter(Object obj) throws Exception {
        checkIfSerializable(obj);
        initialize(obj);
        return convertToJsonString(obj);
    }
}
