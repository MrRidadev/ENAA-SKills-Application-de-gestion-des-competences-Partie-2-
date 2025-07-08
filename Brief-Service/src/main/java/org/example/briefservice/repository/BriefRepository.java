package org.example.briefservice.repository;
import org.example.briefservice.model.Brief;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BriefRepository extends JpaRepository<Brief, Long> {
}
