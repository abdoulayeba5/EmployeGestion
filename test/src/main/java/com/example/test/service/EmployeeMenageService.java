package com.example.test.service;

import com.example.test.entity.Department;
import com.example.test.entity.Employee;
import com.example.test.repository.DepartmentRepository;
import com.example.test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeMenageService {

    @Autowired
    private EmployeeRepository Repository;

    @Autowired
    private DepartmentRepository depRepository;

    public ResponseEntity<List<Employee>> getAllEmployes(){
        try {
            List<Employee> employees = new ArrayList<Employee>();
            Repository.findAll().forEach(employees::add);
            if(employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(employees,HttpStatus.OK);
            }
        }
        catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Employee> getEmployeById(Long id ){
        Optional<Employee> employe = Repository.findById(id);
        if(employe.isPresent()) {
            return new ResponseEntity<Employee>(employe.get(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    public ResponseEntity<Employee> createEmploye(Employee employee) {
        try {
            Optional<Department> dep = depRepository.findById(employee.getDepartement().getId());
            if (dep.isPresent()) {
                Employee _employee = Repository.save(new Employee(employee.getRef(), employee.getAge(), employee.getRole(), dep.get()));
                return new ResponseEntity<>(_employee, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Employee> updateEmploye(Long id, Employee employee) {
        Optional<Employee> employeData = Repository.findById(id);
        Optional<Department> dep = depRepository.findById(employee.getDepartement().getId());
        if(employeData.isPresent()) {
            Employee _employee =employeData.get();
            _employee.setRef(employee.getRef());
            _employee.setDepartement(dep.get());

            return new ResponseEntity<Employee>(Repository.save(_employee),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<HttpStatus> deleteEmployeById(Long id){
        try {
            Repository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
