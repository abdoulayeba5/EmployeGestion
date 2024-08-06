package com.example.test.service;

import com.example.test.entity.AppRole;
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



    public List<Employe> employeMaxAge(int min,int max) {
        Specification<Employe> spec = Specification.where(EmployeSpecification.hasAge(min, max));
        return Repository.findAll(spec);
    }


    public List<Employe> getAll(AppRole role, Long age,String dep) {

        Specification<Employe> spec = Specification.where(

                role ==null? null:EmployeSpecification.HasRole(role)
                ).and(
                        age == null? null:EmployeSpecification.filterByAge(age)
        ).and(
                dep ==null?null : EmployeSpecification.FilterByDep(dep)
        );
        return Repository.findAll(spec);
    }

}
