package org.example.validationservice.Services;

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


    // ajouter validation
    public Validation addValidation(Validation validation) {
        return repository.save(validation);
    }

    // get all validation
    public List<Validation> getAllValidations() {
        return repository.findAll();
    }



        @Autowired
        private ValidationRepository validationRepository;

        public Validation associateCompetence(Long validationId, Long competenceId) {
            Optional<Validation> optionalValidation = validationRepository.findById(validationId);

            if (optionalValidation.isPresent()) {
                Validation validation = optionalValidation.get();
                validation.setCompetenceId(competenceId); // assign the competence
                return validationRepository.save(validation);
            }

            return null;
        }
}
