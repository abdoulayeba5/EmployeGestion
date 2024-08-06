package com.example.test.specification;

import com.example.test.entity.AppRole;
import com.example.test.entity.Departement;
import com.example.test.entity.Employe;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class EmployeSpecification {
    public static Specification<Employe> HasRole(AppRole role){
    return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("role"), role));
    }
    public static Specification<Employe> filterByAge(Long age){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("age"), age));
    }

public static Specification<Employe> FilterByDep(String name) {
    return (root, query, criteriaBuilder) -> {
        Join<Employe, Departement> departementJoin = root.join("departement");
        return criteriaBuilder.equal(departementJoin.get("name"), name);
    };
}
public static Specification<Employe> hasAge(int min,int max){
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("age"),min,max);
}

}

