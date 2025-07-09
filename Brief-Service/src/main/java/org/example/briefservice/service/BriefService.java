package org.example.briefservice.service;

import org.example.briefservice.model.Brief;
import org.example.briefservice.repository.BriefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BriefService {

    private final BriefRepository briefRepository;

    public BriefService(BriefRepository briefRepository) {
        this.briefRepository = briefRepository;
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
}
