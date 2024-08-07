package com.example.test.service;

import com.example.test.entity.AppRole;
import com.example.test.entity.Employee;
import com.example.test.repository.EmployeeRepository;
import com.example.test.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeFilterService {
    @Autowired
    private EmployeeRepository Repository;



    public List<Employee> employeMaxAge(int min, int max) {
        Specification<Employee> spec = Specification.where(EmployeeSpecification.hasAge(min, max));
        return Repository.findAll(spec);
    }


    public List<Employee> getAll(AppRole role, Long age, String dep) {

        Specification<Employee> spec = Specification.where(

                role ==null? null: EmployeeSpecification.HasRole(role)
                ).and(
                        age == null? null: EmployeeSpecification.filterByAge(age)
        ).and(
                dep ==null?null : EmployeeSpecification.FilterByDep(dep)
        );
        return Repository.findAll(spec);
    }

}
