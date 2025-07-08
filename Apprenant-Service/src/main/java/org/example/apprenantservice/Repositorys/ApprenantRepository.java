package org.example.apprenantservice.Repositorys;

import org.example.apprenantservice.Modeles.Apprernat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantRepository extends JpaRepository<Apprernat,Long> {
}
