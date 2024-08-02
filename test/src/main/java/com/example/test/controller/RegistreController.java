package com.example.test.controller;

import com.example.test.entity.MyUser;
import com.example.test.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistreController {

    @Autowired
    private MyUserRepository repository;


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistreController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/registre")
    public MyUser adduser(@RequestBody MyUser user){
        System.out.println("username -> "+user.getPassword()+"\npassword -> "+user.getUsername()+"\nrole -> "+user.getRole());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
