package org.example.competenceservice;

import org.example.competenceservice.DTOs.SousCompetenceDTO;
import org.example.competenceservice.Modeles.Competence;
import org.example.competenceservice.Modeles.SousCompetence;
import org.example.competenceservice.Modeles.StatutValidation;
import org.example.competenceservice.Repositorys.CompetenceRepository;
import org.example.competenceservice.Repositorys.SousCompetenceRepository;
import org.example.competenceservice.Services.SousCompetenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(SousCompetenceService.class)
public class SousCompetenceServiceTest {

    @Autowired
    private SousCompetenceService sousCompetenceService;


    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private SousCompetenceRepository sousCompetenceRepository;

    @Test
    public void testAddSousCompetence() {
        // Given : créer une compétence
        Competence competence = new Competence();
        competence.setNom("Programmation Java");
        competence = competenceRepository.save(competence);

        // Préparer le DTO
        SousCompetenceDTO dto = new SousCompetenceDTO();
        dto.setNom("POO");
        dto.setStatutValidation(StatutValidation.EN_ATTENTE);
        dto.setCompetenceId(competence.getId());

        // When
        SousCompetence saved = sousCompetenceService.addSousCompetence(dto);

        // Then
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getNom()).isEqualTo("POO");
        assertThat(saved.getStatutValidation()).isEqualTo(StatutValidation.EN_ATTENTE);
        assertThat(saved.getCompetence().getId()).isEqualTo(competence.getId());
    }
}
