package org.example.authservice.repositorys;

import org.example.authservice.modeles.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
}
