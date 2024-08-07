package com.example.test.entity;

import jakarta.persistence.*;

@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private Long age ;

    private AppRole role;


    @ManyToOne()
    @JoinColumn(name = "department_id",referencedColumnName = "id")
//    @JsonManagedReference
    private Department department;

    public Employee(String ref, Long age, AppRole role, Department department) {
        this.ref = ref;
        this.age = age;
        this.role=role;
        this.department = department;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Employee() {
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Department getDepartement() {
        return department;
    }

    public void setDepartement(Department department) {
        this.department = department;
    }
}
