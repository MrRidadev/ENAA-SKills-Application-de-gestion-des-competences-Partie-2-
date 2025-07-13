package org.example.briefservice.client;

import org.example.briefservice.DTO.CompetenceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Competence-Service", url = "http://Competence-Service:8087")

    public interface CompetenceClient {

        @GetMapping("/competences")
        List<CompetenceDTO> getAllCompetences();

        @GetMapping("/competences/{id}")
        CompetenceDTO getCompetenceById(@PathVariable Long id);
    }


