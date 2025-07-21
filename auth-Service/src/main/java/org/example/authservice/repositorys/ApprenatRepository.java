package org.example.authservice.repositorys;

import org.example.authservice.modeles.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApprenatRepository extends JpaRepository<Apprenant,Long> {

    Optional<Apprenant> findByEmail(String email);
}
