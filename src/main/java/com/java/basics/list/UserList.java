package com.java.basics.list;

import javax.management.AttributeList;
import java.util.*;

public class UserList {

    public static void main(String[] args) {
        List<UserDTO> userDTOS = Arrays.asList(new UserDTO(12,"A"), new UserDTO(2, "a"), new UserDTO(3, "c"));
        Collections.sort(userDTOS);
        userDTOS.forEach(System.out::println);
        System.out.println();
        userDTOS.sort(new Comparator<UserDTO>() {
            @Override
            public int compare(UserDTO o1, UserDTO o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        userDTOS.forEach(System.out::println);
        userDTOS.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        userDTOS.sort(Comparator.comparing(UserDTO::getName));
        userDTOS.sort(Comparator.comparing(UserDTO::getName, Comparator.comparing(String::trim)));
        userDTOS.forEach(System.out::println);
        AbstractList<String> strings ; // to minimize the effort required to implement List interface
        AbstractSequentialList<String> strings1; // for LinkedList
        AttributeList x = new AttributeList();
    }
}
