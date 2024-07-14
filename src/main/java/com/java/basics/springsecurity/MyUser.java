package com.java.basics.springsecurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class MyUser extends User {

    private String username;
    private String password;
    private String roles;
    public MyUser(String username, String password, String roles) {
        super(username, password, Arrays.stream(roles.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}
