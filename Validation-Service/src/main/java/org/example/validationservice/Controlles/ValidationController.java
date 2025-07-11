package org.example.validationservice.Controlles;

import org.example.validationservice.Modeles.Validation;
import org.example.validationservice.Services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Validation")
public class ValidationController {

    @Autowired
    private ValidationService validationService;
    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }


    // ajouter validation en controller
    @PostMapping("/add-validation")
    public Validation ajoutervalidation(@RequestBody Validation validation) {
        return validationService.addValidation(validation);
    }
}
