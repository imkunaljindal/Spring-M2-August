package com.example.SecurityTutorial.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/home")
    public String home() {
        return "This is HOME page";
    }

    @GetMapping("/student")
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    public String student() {
        return "Welcome to the STUDENT page";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Welcome to the ADMIN page";
    }
}
