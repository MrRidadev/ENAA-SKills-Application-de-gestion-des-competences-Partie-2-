package org.example.authservice.repositorys;

import org.example.authservice.modeles.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
    Optional<Administrateur> findByEmail(String email);
}
