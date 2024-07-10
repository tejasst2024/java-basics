package com.java.basics.list;

import lombok.Builder;
import lombok.Data;

import java.util.Comparator;

@Data
@Builder
public class UserDTO  implements Comparable<UserDTO> {

    private Integer id;
    private String name;

    @Override
    public int compareTo(UserDTO o) {
        return id.compareTo(o.id);
    }
}
