package org.example.apprenantservice.Modeles;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Rendu {

    @Id
    @GeneratedValue
    private Long id;
    private String lien;
    private Date dateDepot;


    @ManyToOne
    private Apprernat apprrent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public Apprernat getApprrent() {
        return apprrent;
    }

    public void setApprrent(Apprernat apprrent) {
        this.apprrent = apprrent;
    }
}
