package com.example.test.controller;

import com.example.test.entity.Employe;
import com.example.test.repository.EmployeRepository;
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

    @GetMapping()
    public ResponseEntity<List<Employe>> getAllEmployes(){
        try {
            List<Employe> employes = new ArrayList<Employe>();
            Repository.findAll().forEach(employes::add);
            if(employes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(employes,HttpStatus.OK);
            }
        }
        catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable("id")Long id ){
        Optional<Employe> employe = Repository.findById(id);
        if(employe.isPresent()) {
            return new ResponseEntity<Employe>(employe.get(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
        try {
            Employe _employe =Repository.save(new Employe( employe.getRef(), employe.getDepartement()));
            return new ResponseEntity<Employe>(_employe, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }}
    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable("id")Long id,@RequestBody Employe employe) {
        Optional<Employe> employeData = Repository.findById(id);
        if(employeData.isPresent()) {
            Employe _employe =employeData.get();
            _employe.setRef(employe.getRef());
            _employe.setDepartement(employe.getDepartement());

            return new ResponseEntity<Employe>(Repository.save(_employe),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeById(@PathVariable("id")Long id){
        try {
            Repository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
