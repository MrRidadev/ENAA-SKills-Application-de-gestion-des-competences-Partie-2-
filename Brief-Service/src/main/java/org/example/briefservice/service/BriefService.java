package org.example.briefservice.service;

import org.example.briefservice.model.Brief;
import org.example.briefservice.repository.BriefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BriefService {

    private final BriefRepository briefRepository;

    public BriefService(BriefRepository briefRepository) {
        this.briefRepository = briefRepository;
    }

    public Brief saveBrief(Brief brief) {
        return briefRepository.save(brief);
    }
}
