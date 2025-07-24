package org.example.briefservice.service;

import org.example.briefservice.DTO.CompetenceDTO;
import org.example.briefservice.client.CompetenceClient;
import org.example.briefservice.model.Brief;
import org.example.briefservice.repository.BriefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BriefService {

    private final BriefRepository briefRepository;
    private final CompetenceClient competenceClient;

    @Autowired
    public BriefService(BriefRepository briefRepository, CompetenceClient competenceClient) {
        this.briefRepository = briefRepository;
        this.competenceClient = competenceClient;
    }

    public Brief saveBrief(Brief brief) {
        return briefRepository.save(brief);
    }

    public List<Brief> getAllBriefs() {
        return briefRepository.findAll();
    }

    public Brief getBriefById(Long id) {
        return briefRepository.findById(id).orElseThrow();
    }

    public Brief updateBrief(Long id, Brief brief) {
        Brief existing = briefRepository.findById(id).orElseThrow();
        existing.setTitre(brief.getTitre());
        existing.setDescription(brief.getDescription());
        existing.setDateDebut(brief.getDateDebut());
        existing.setDateFin(brief.getDateFin());
        return briefRepository.save(existing);
    }

    public List<CompetenceDTO> assiociation(Long briefId, List<Long> competenceIds) {
        Brief brief = getBriefById(briefId);
        if (brief == null) {
            return null;
        }
        List<CompetenceDTO> competencesAssigned = new ArrayList<>();
        for (Long competenceId : competenceIds) {
            CompetenceDTO competence = competenceClient.getCompetenceById(competenceId);
            if (competence != null) {
                competencesAssigned.add(competence);
                brief.getCompetenceIds().add(competenceId);
            }
        }
        briefRepository.save(brief);
        return competencesAssigned;
    }

}
