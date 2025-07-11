package org.example.apprenantservice.services;

import org.example.apprenantservice.DTOs.BriefDto;
import org.example.apprenantservice.Modeles.Rendu;
import org.example.apprenantservice.Repositorys.RenduRepository;
import org.example.apprenantservice.feign.BriefClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenduService {

    @Autowired
    private RenduRepository renduRepository;
    @Autowired
    private  BriefClient briefClient;

    public BriefClient getBriefClient() {
        return briefClient;
    }

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


    public Rendu saveRendu(Rendu rendu) {
        // Vérifier que le brief existe
        BriefDto brief = briefClient.getBriefById(rendu.getBriefId());
        if (brief == null) {
            throw new RuntimeException("Brief non trouvé pour ID : " + rendu.getBriefId());
        }

        return renduRepository.save(rendu);
    }
}
