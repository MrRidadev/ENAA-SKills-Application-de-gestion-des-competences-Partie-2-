package org.example.validationservice.Services;
import org.example.briefservice.DTO.CompetenceDTO;
import org.example.briefservice.client.CompetenceClient;
import org.example.validationservice.Modeles.Validation;
import org.example.validationservice.Repositorys.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValidationService {

    @Autowired
    private ValidationRepository repository;
    public ValidationService(ValidationRepository repository) {
        this.repository = repository;
    }

    public Validation addValidation(Validation validation) {
        return repository.save(validation);
    }

    public List<Validation> getAllValidations() {
        return repository.findAll();
    }

    @Autowired
    private CompetenceClient competenceClient;

    @Autowired
    private ValidationRepository validationRepository;


    public Validation associateCompetence(Long validationId, Long competenceId) {
        Validation validation = validationRepository.findById(validationId)
                .orElseThrow(() -> new RuntimeException("Validation not found"));

        // Fetch competence to check if it exists
        CompetenceDTO competence = competenceClient.getCompetenceById(competenceId);
        if (competence == null) {
            throw new RuntimeException("Competence not found");
        }

        // Associate
        validation.setCompetenceId(competenceId);
        return validationRepository.save(validation);
    }


}
