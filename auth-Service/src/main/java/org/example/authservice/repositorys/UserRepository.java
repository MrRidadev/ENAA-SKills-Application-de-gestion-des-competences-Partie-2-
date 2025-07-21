package org.example.authservice.repositorys;

import org.example.authservice.modeles.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
