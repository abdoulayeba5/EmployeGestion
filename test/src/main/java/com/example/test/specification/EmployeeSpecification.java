package com.example.test.specification;

import com.example.test.entity.AppRole;
import com.example.test.entity.Department;
import com.example.test.entity.Employee;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {
    public static Specification<Employee> HasRole(AppRole role){
    return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("role"), role));
    }
    public static Specification<Employee> filterByAge(Long age){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("age"), age));
    }

public static Specification<Employee> FilterByDep(String name) {
    return (root, query, criteriaBuilder) -> {
        Join<Employee, Department> departementJoin = root.join("departement");
        return criteriaBuilder.equal(departementJoin.get("name"), name);
    };
}
public static Specification<Employee> hasAge(int min, int max){
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("age"),min,max);
}

}

