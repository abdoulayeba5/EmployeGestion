package com.example.test.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy ="departement" ,cascade = CascadeType.ALL)
    private Set<Employe> employes;

    public Departement(String name) {
        this.name = name;
    }

    public Departement() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(Set<Employe> employes) {
        this.employes = employes;
    }
}
