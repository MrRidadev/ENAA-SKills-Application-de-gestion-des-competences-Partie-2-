package org.example.validationservice.client;


import org.example.briefservice.DTO.CompetenceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface validation {

    @FeignClient(name = "competence-service", url = "http://localhost:8182")
    public interface CompetenceClient {

        @GetMapping("/competences/{id}")
        CompetenceDTO getCompetenceById(@PathVariable Long id);

    }
}
