package com.java.basics.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// runs with spring version 3.2.4
//@Configuration
public class NewSecurityConfiguration {

//    @Autowired
//    MyUserService userService;

//    @Override
//    public void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder.inMemoryAuthentication().withUser("user").password("pass").roles();
//
//    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        List<String> rolesAdmin = Arrays.asList("ADMIN");
//        List<String> rolesUser = Arrays.asList("USER");
//        List<String> rolesAuth = Arrays.asList("ADMIN","USER");
//
//        UserDetails userDetails1 = new User("admin2", "pass", Collections.singleton(new SimpleGrantedAuthority("ADMIN")));
//        UserDetails userDetails2 = new User("user", "pass", Collections.singleton(new SimpleGrantedAuthority("USER")));
//
//        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager1() {
//        List<String> rolesAdmin = Arrays.asList("ADMIN");
//        List<String> rolesUser = Arrays.asList("USER");
//        List<String> rolesAuth = Arrays.asList("ADMIN","USER");
//
//        UserDetails userDetails1 = new User("admin1", "pass", Collections.singleton(new SimpleGrantedAuthority("ADMIN")));
//        UserDetails userDetails2 = new User("user", "pass", Collections.singleton(new SimpleGrantedAuthority("USER")));
//
//        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Bean
//    public SecurityFilterChain getSecurityFilter(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests((req) -> {
//            try {
//                httpSecurity.formLogin(Customizer.withDefaults());
//                req
//                        .requestMatchers("/").permitAll()
//                        .requestMatchers("/admin**").hasAuthority("ADMIN")
//                        .requestMatchers("/user**").hasAuthority("USER");
//
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//        return httpSecurity.build();
//    }
}
