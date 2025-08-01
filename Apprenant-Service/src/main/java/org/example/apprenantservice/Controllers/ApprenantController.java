package org.example.apprenantservice.Controllers;


import org.example.apprenantservice.Modeles.Apprenant;
import org.example.apprenantservice.Repositorys.ApprenantRepository;
import org.example.apprenantservice.services.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Apprenant")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;
    private ApprenantRepository apprenantRepository;
    public ApprenantController(ApprenantService apprenantService) {
        this.apprenantService = apprenantService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Apprenant ajouterApprenant(@RequestBody Apprenant apprenant) {
        return apprenantService.addApprenat(apprenant);
    }
    @GetMapping("/allApprenant")
    public List<Apprenant> getAllApprenant() {
        return apprenantRepository.findAll();
    }
}
