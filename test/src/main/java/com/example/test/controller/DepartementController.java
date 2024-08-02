package com.example.test.controller;

import com.example.test.entity.Departement;
import com.example.test.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dep")
public class DepartementController {

    @Autowired
    private DepartementRepository Repository;
    @GetMapping
    public List<Departement> getalldep(){

        return Repository.findAll();
    }
    @PostMapping
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) {
        try {
            Departement _departement =Repository.save(new Departement( departement.getName()));
            return new ResponseEntity<Departement>(_departement, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }}
}
