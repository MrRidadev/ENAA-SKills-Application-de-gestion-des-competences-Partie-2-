package org.example.validationservice.Modeles;


import jakarta.persistence.*;

@Entity
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatutValidationEnum statutValidation = StatutValidationEnum.EN_ATTENTE;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatutValidationEnum getStatutValidation() {
        return statutValidation;
    }

    public void setStatutValidation(StatutValidationEnum statutValidation) {
        this.statutValidation = statutValidation;
    }
}
