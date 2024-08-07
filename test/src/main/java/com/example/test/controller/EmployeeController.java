package com.example.test.controller;

import com.example.test.entity.AppRole;
import com.example.test.entity.Employee;
import com.example.test.repository.EmployeeRepository;
import com.example.test.service.EmployeeFilterService;
import com.example.test.service.EmployeeMenageService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository Repository;

    @Autowired
    private  final EmployeeFilterService Service;

    @Autowired
    private  final EmployeeMenageService MenageService;

    public EmployeeController(EmployeeFilterService service, EmployeeMenageService menageService) {
        Service = service;
        MenageService = menageService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeById(@PathVariable("id")Long id ){
      return MenageService.getEmployeById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> createEmploye(@RequestBody Employee employee) {
      return MenageService.createEmploye(employee);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmploye(@PathVariable("id")Long id, @RequestBody Employee employee) {
      return MenageService.updateEmploye(id, employee);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeById(@PathVariable("id")Long id){
      return MenageService.deleteEmployeById(id);
    }


    @GetMapping()
    public List<Employee> employeFilter(@PathParam("role") AppRole role , @PathParam("age") Long age, @PathParam("dep") String dep) {
        return Service.getAll(role,age,dep);
    }
}
