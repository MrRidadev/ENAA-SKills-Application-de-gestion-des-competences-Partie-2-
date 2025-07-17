package org.example.authservice.repositorys;

import org.example.authservice.modeles.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


}
