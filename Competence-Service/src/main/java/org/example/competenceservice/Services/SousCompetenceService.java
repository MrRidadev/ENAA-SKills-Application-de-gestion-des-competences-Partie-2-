package org.example.competenceservice.Services;

import org.example.competenceservice.DTOs.SousCompetenceDTO;
import org.example.competenceservice.Modeles.Competence;
import org.example.competenceservice.Modeles.SousCompetence;
import org.example.competenceservice.Repositorys.CompetenceRepository;
import org.example.competenceservice.Repositorys.SousCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SousCompetenceService {

    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private SousCompetenceRepository sousCompetenceRepository;

    public SousCompetenceService(SousCompetenceRepository sousCompetenceRepository) {
        this.sousCompetenceRepository = sousCompetenceRepository;
    }

    // ajouter SousCompetence
    public SousCompetence addSousCompetence(SousCompetenceDTO dto) {
        Competence competence = competenceRepository.findById(dto.getCompetenceId())
                .orElseThrow(() -> new RuntimeException("Compétence introuvable"));

        SousCompetence sousCompetence = new SousCompetence();
        sousCompetence.setNom(dto.getNom());
        sousCompetence.setStatutValidation(dto.getStatutValidation());
        sousCompetence.setCompetence(competence);

        return sousCompetenceRepository.save(sousCompetence);
    }


    public List<SousCompetence> getAllSousCompetences(long id) {
        if (competenceRepository.existsById(id)) {
            return sousCompetenceRepository.findSousCompetenceByCompetenceId(id);
        } else {
            System.out.println("La compétence avec l'ID " + id + " n'existe pas.");
            // Retourne une liste vide
            return new ArrayList<>();
        }
    }

    //modifier SousCompetence
    public SousCompetence updateSousCompetence(SousCompetence sousCompetence) {
        return sousCompetenceRepository.save(sousCompetence);
    }
}
