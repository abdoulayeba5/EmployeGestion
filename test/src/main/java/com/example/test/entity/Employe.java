package com.example.test.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity

public class Employe{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private Long age ;

    private AppRole role;


    @ManyToOne()
    @JoinColumn(name = "departement_id",referencedColumnName = "id")
//    @JsonManagedReference
    private Departement departement;

    public Employe(String ref, Long age,AppRole role, Departement departement) {
        this.ref = ref;
        this.age = age;
        this.role=role;
        this.departement = departement;
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

    public Employe() {
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
