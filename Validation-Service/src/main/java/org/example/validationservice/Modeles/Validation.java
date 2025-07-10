package org.example.validationservice.Modeles;


import jakarta.persistence.*;

@Entity
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatutValidationEnum statutValidation = StatutValidationEnum.EN_ATTENTE;


}
