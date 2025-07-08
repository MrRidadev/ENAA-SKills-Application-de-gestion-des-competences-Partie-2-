package org.example.apprenantservice.Controllers;


import org.example.apprenantservice.Modeles.Rendu;
import org.example.apprenantservice.services.RenduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Rendu")
public class RenduController {

    @Autowired
    private RenduService renduService;
    public RenduController(RenduService renduService) {
        this.renduService = renduService;
    }

    @PostMapping("/ajouter-Rendu")
    public Rendu ajouterRendu(@RequestBody Rendu rendu) {
        return renduService.ajouterRendu(rendu);
    }
}
