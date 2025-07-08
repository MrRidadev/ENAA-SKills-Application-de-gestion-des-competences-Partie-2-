package org.example.apprenantservice.services;

import org.example.apprenantservice.Modeles.Rendu;
import org.example.apprenantservice.Repositorys.RenduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenduService {

    @Autowired
    private RenduRepository renduRepository;

    public RenduService(RenduRepository renduRepository) {
        this.renduRepository = renduRepository;
    }

    // ajouter rendu
    public Rendu ajouterRendu(Rendu rendu) {
        return renduRepository.save(rendu);
    }

    // afficher les rendus
    public List<Rendu> getRendus() {
        return renduRepository.findAll();
    }
}
