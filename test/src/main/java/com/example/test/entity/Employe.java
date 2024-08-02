package com.example.test.entity;

import jakarta.persistence.*;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;

    @ManyToOne
    private Departement departement;

    public Employe(String ref, Departement departement) {
        this.ref = ref;
        this.departement = departement;
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
