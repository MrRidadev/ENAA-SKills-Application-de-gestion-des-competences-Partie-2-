package org.example.competenceservice.DTOs;

import org.example.competenceservice.Modeles.StatutValidation;

public class SousCompetenceDTO {

    private String nom;
    private StatutValidation statutValidation;
    private Long competenceId;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public StatutValidation getStatutValidation() {
        return statutValidation;
    }

    public void setStatutValidation(StatutValidation statutValidation) {
        this.statutValidation = statutValidation;
    }

    public Long getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
    }
}
