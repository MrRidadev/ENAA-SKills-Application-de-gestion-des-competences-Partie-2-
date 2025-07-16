package org.example.authservice.repositorys;

import org.example.authservice.modeles.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenatRepository extends JpaRepository<Apprenant,Long> {
}
