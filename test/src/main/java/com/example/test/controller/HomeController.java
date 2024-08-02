package com.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home(){
        return "welcome";
    }
    @GetMapping("/admin")
    public String homeAdmin(){
        return "welcome admin";
    }
    @GetMapping("/user")
    public String homeUser(){
        return "welcome user";
    }

}
