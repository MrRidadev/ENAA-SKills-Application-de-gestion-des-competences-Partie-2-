package org.example.validationservice.DTO;

public class competenceDTO {

    private Long id;
    private String nom;
    private String statutValidation;

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

    public String getStatutValidation() {
        return statutValidation;
    }

    public void setStatutValidation(String statutValidation) {
        this.statutValidation = statutValidation;
    }

    public competenceDTO(Long id, String nom, String statutValidation) {
        this.id = id;
        this.nom = nom;
        this.statutValidation = statutValidation;
    }

    public competenceDTO() {
    }
}
