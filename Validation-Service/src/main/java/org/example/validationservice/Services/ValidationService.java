package org.example.validationservice.Services;

import org.example.validationservice.Modeles.Validation;
import org.example.validationservice.Repositorys.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
