package com.example.test.controller;

import com.example.test.entity.Employe;
import com.example.test.repository.EmployeRepository;
import com.example.test.service.EmployeFilterService;
import com.example.test.service.EmployeMenageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employe")
public class EmployeController {

    @Autowired
    private EmployeRepository Repository;

    @Autowired
    private  final EmployeFilterService Service;

    @Autowired
    private  final EmployeMenageService MenageService;

    public EmployeController(EmployeFilterService service, EmployeMenageService menageService) {
        Service = service;
        MenageService = menageService;
    }

    @GetMapping()
    public ResponseEntity<List<Employe>> getAllEmployes(){
    return MenageService.getAllEmployes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable("id")Long id ){
      return MenageService.getEmployeById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
      return MenageService.createEmploye(employe);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable("id")Long id,@RequestBody Employe employe) {
      return MenageService.updateEmploye(id,employe);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeById(@PathVariable("id")Long id){
      return MenageService.deleteEmployeById(id);
    }

    @GetMapping("/role/{role}")
    public List<Employe> employeRole(@PathVariable("role") String role){
        return Service.employeRole(role);
    }

    @GetMapping("/dep/{dep}")
    public List<Employe> employeDep(@PathVariable("dep") String dep){
        return Service.employeDep(dep);

    }
    @GetMapping("/age/{min},{max}")
    public List<Employe> employeMaxAge(@PathVariable("min") int min, @PathVariable("max") int max) {
      return Service.employeMaxAge(min,max);
    }

}
