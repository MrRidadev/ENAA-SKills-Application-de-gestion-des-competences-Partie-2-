package org.example.validationservice.Controlles;

import org.example.validationservice.Modeles.Validation;
import org.example.validationservice.Services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/validations")
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

    // implementer get validation
    @GetMapping("/get-Validation")
    public List<Validation> getValidation() {
        return validationService.getAllValidations();
    }


    @PostMapping("/{validationId}/associate-competence/{competenceId}")
    public ResponseEntity<Validation> associateCompetence(
            @PathVariable Long validationId,
            @PathVariable Long competenceId) {
        return ResponseEntity.ok(
                validationService.associateCompetence(validationId, competenceId)
        );
    }
}
