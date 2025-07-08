package org.example.competenceservice;

import org.example.competenceservice.Modeles.Competence;
import org.example.competenceservice.Modeles.StatutValidation;
import org.example.competenceservice.Repositorys.CompetenceRepository;
import org.example.competenceservice.Services.CompetenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // utilise H2 en mémoire
@Import(CompetenceService.class) // Injecte le vrai service dans le test
public class CompetenceServiceTest {


    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private CompetenceService competenceService;

    @Test
    public void testAjouterCompetence() {
        // Given
        Competence competence = new Competence();
        competence.setNom("Java Spring Boot");

        // When
        Competence saved = competenceService.ajouterCompetence(competence);

        // Then
        Optional<Competence> fetched = competenceRepository.findById(saved.getId());
        assertThat(fetched).isPresent();
        assertThat(fetched.get().getNom()).isEqualTo("Java Spring Boot");
        assertThat(fetched.get().getStatutValidation()).isEqualTo(StatutValidation.EN_ATTENTE);
    }


}
