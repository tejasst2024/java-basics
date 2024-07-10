package com.java.basics.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class Controller {
    @GetMapping("/")
    public String getData() {
        return "<h1>Hello Everyone</h1>";
    }

    @GetMapping("/auth")
    public String getAuthenticatedData() {
        return "<h1>Hello Authenticated User</h1>";
    }

    @GetMapping("/admin")
    public String getAdminData() {
        return "<h1>Hello Admin</h1>";
    }

    @GetMapping("/user")
    public String getUserData() {
        return "<h1>Hello User</h1>";
    }
}
