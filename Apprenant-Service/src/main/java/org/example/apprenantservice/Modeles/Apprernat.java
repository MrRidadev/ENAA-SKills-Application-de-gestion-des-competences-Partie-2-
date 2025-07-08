package org.example.apprenantservice.Modeles;


import jakarta.persistence.Entity;

import jakarta.persistence.*;

@Entity
public class Apprernat {
    @Id
    @GeneratedValue
    private Long id;
    private String nomComplet;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
