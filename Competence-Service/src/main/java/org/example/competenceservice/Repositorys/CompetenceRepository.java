package org.example.competenceservice.Repositorys;

import org.example.competenceservice.Modeles.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
}
