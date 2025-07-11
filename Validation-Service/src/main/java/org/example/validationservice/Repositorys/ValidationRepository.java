package org.example.validationservice.Repositorys;

import org.example.validationservice.Modeles.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository  extends JpaRepository<Validation, Long> {
}
