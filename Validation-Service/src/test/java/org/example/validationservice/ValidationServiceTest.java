package org.example.validationservice;


import org.example.validationservice.Modeles.StatutValidationEnum;
import org.example.validationservice.Modeles.Validation;
import org.example.validationservice.Repositorys.ValidationRepository;
import org.example.validationservice.Services.ValidationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(ValidationService.class)
public class ValidationServiceTest {

    @Autowired
    private ValidationRepository validationRepository;

    @Autowired
    private ValidationService validationService;

    @Test
    public void testAddValidation() {

        Validation validation = new Validation();
        validation.setStatutValidation(StatutValidationEnum.VALIDE);


        Validation saved = validationService.addValidation(validation);


        assertNotNull(saved.getId());
        assertEquals(StatutValidationEnum.VALIDE, saved.getStatutValidation());
    }

    @Test
    public void testGetAllValidations() {

        Validation v1 = new Validation();
        v1.setStatutValidation(StatutValidationEnum.VALIDE);

        Validation v2 = new Validation();
        v2.setStatutValidation(StatutValidationEnum.NON_VALIDE);

        validationService.addValidation(v1);
        validationService.addValidation(v2);


        List<Validation> result = validationService.getAllValidations();


        assertEquals(2, result.size());
    }


}

