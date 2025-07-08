package org.example.competenceservice.Controllers;

import org.example.competenceservice.DTOs.SousCompetenceDTO;
import org.example.competenceservice.Modeles.SousCompetence;
import org.example.competenceservice.Repositorys.SousCompetenceRepository;
import org.example.competenceservice.Services.SousCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/SousCompetence")
public class SousCompetenceController {


    @Autowired
    private SousCompetenceRepository sousCompetenceRepository;
    @Autowired
    private SousCompetenceService sousCompetenceService;

    public SousCompetenceController(SousCompetenceService sousCompetenceService) {
        this.sousCompetenceService = sousCompetenceService;
    }

    // ajouter SousCompetence
    @PostMapping("/add-SousCompetence")
    public SousCompetence addSousCompetence(@RequestBody SousCompetenceDTO souscompetenceDTO) {
        return sousCompetenceService.addSousCompetence(souscompetenceDTO);
    }

    @GetMapping("/getSCByC/{id}")
    public List<SousCompetence> getAllSousCompetence(@PathVariable long id) {
        return sousCompetenceRepository.findCompetenceByCompetenceId(id);
    }

    @GetMapping("/getCompetence/{id}")
    public List<SousCompetence> getCompetence(@PathVariable long id) {
        return sousCompetenceService.getAllSousCompetences(id);
    }

    @PutMapping("/putSousCompetence")
    public SousCompetence update(@RequestBody SousCompetence sousCompetence) {
        return sousCompetenceService.updateSousCompetence(sousCompetence);
    }
}
