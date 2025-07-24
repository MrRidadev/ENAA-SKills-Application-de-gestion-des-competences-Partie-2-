package org.example.briefservice.controller;
import org.example.briefservice.dto.CompetenceDTO;
import org.example.briefservice.model.Brief;
import org.example.briefservice.repository.BriefRepository;
import org.example.briefservice.service.BriefService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/briefs")

public class BriefController {


    private BriefService briefService;

    private BriefRepository briefRepository;

    public BriefController(BriefService briefService, BriefRepository briefRepository) {
        this.briefService = briefService;
        this.briefRepository = briefRepository;
    }
    @PostMapping("ajouter-breif")
    public ResponseEntity<Brief> create(@RequestBody Brief brief) {
        return ResponseEntity.ok(briefService.saveBrief(brief));
    }

    @GetMapping
    public ResponseEntity<List<Brief>> getAll() {
        return ResponseEntity.ok(briefService.getAllBriefs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brief> getById(@PathVariable Long id) {
        return ResponseEntity.ok(briefService.getBriefById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brief> update(@PathVariable Long id, @RequestBody Brief brief) {
        return ResponseEntity.ok(briefService.updateBrief(id, brief));
    }
    @PostMapping("/association/{briefId}")
    public List<CompetenceDTO> assiociationCompetences(@PathVariable Long briefId, @RequestBody List<Long> competenceIds) {
        return briefService.assiociation(briefId, competenceIds);  // Passing the list of IDs to service
    }


    @GetMapping("/briefs/{id}")
    public ResponseEntity<Brief> getBriefById(@PathVariable Long id) {
        Optional<Brief> brief = briefRepository.findById(id);
        return brief.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



}
