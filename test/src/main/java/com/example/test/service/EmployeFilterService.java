package com.example.test.service;

import com.example.test.entity.Employe;
import com.example.test.repository.EmployeRepository;
import com.example.test.specification.EmployeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeFilterService {
    @Autowired
    private EmployeRepository Repository;


    public List<Employe> employeDep( String dep){
        System.out.println(dep);
        Specification<Employe> spec=Specification.where(EmployeSpecification.hasDep(dep));
        return Repository.findAll(spec);

    }
    public List<Employe> employeMaxAge(int min,int max) {
        System.out.println("Min age: " + min + ", Max age: " + max);
        Specification<Employe> spec = Specification.where(EmployeSpecification.hasAge(min, max));
        return Repository.findAll(spec);
    }

    public List<Employe> employeRole(String role){
        System.out.println(role);
        Specification<Employe> spec=Specification.where(EmployeSpecification.HasRole(role));
        return Repository.findAll(spec);

    }

}
