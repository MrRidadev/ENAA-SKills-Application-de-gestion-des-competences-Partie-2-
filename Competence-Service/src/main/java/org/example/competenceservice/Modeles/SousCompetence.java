package org.example.competenceservice.Modeles;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class SousCompetence {

    @Id
    @GeneratedValue
    private Long id;
    private String nom;

    @ManyToOne
    @JsonBackReference
    private Competence competence;

    @Enumerated(EnumType.STRING)
    private StatutValidation statutValidation ;


    public StatutValidation getStatutValidation() {
        return statutValidation;
    }

    public void setStatutValidation(StatutValidation statutValidation) {
        this.statutValidation = statutValidation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

}
