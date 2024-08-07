package com.example.test.controller;

import com.example.test.entity.Department;
import com.example.test.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dep")
public class DepartmentController {

    @Autowired
    private DepartmentRepository Repository;
    @GetMapping
    public List<Department> getalldep(){

        return Repository.findAll();
    }
    @PostMapping
    public ResponseEntity<Department> createDepartement(@RequestBody Department department) {
        try {
            Department _department =Repository.save(new Department( department.getName()));
            return new ResponseEntity<Department>(_department, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }}
}
