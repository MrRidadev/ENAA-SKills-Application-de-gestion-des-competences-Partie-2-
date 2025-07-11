package org.example.briefservice.controller;
import org.example.briefservice.DTO.CompetenceDTO;
import org.example.briefservice.model.Brief;
import org.example.briefservice.service.BriefService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/briefs")

public class BriefController {


    private final BriefService briefService;

    public BriefController(BriefService briefService) {
        this.briefService = briefService;
    }

    @PostMapping
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
    @PostMapping ("/association/{briefId}/{competenceId}")
    public List<CompetenceDTO> assiociationCompetences(@PathVariable Long competenceId , @PathVariable Long briefId) {
        return briefService.assiociation(briefId,competenceId);
    }

}
