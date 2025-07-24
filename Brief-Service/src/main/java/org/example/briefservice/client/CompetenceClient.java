package org.example.briefservice.client;
import org.example.briefservice.dto.CompetenceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


@FeignClient(name = "Competence-Service",url = "http://localhost:8182")

    public interface CompetenceClient {

        @GetMapping("/competences")
        List<CompetenceDTO> getAllCompetences();

        @GetMapping("/competences/{id}")
        CompetenceDTO getCompetenceById(@PathVariable Long id);

    }


