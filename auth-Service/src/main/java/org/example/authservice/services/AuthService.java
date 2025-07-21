package org.example.authservice.services;

import org.example.authservice.dtos.AuthResponse;
import org.example.authservice.dtos.LoginRequest;
import org.example.authservice.dtos.RegisterRequest;
import org.example.authservice.modeles.*;
import org.example.authservice.repositorys.AdministrateurRepository;
import org.example.authservice.repositorys.ApprenatRepository;
import org.example.authservice.repositorys.FormateurRepository;
import org.example.authservice.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private ApprenatRepository apprenatRepository;

    @Autowired
    private FormateurRepository formateurRepository;

    @Autowired
    private AdministrateurRepository administrateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {
        // Vérifier si l'email existe déjà
        if (emailExists(request.getEmail())) {
            throw new RuntimeException("Email déjà utilisé");
        }

        // Crer l'utilisateur selon son role
        User user = createUserByRole(request);

        // Encoder le mot de passe
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setRole(request.getRole());

        // Sauvegarder l'utilisateur
        saveUserByRole(user);

        // Genérer le token JWT
        String token = jwtService.generateToken(user.getEmail(), user.getRole().name());

        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        // Rechercher l'utilisateur par email
        User user = findUserByEmail(request.getEmail());

        if (user == null) {
            throw new RuntimeException("Email ou mot de passe incorrect");
        }

        // Verifier le mot de passe
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Email ou mot de passe incorrect");
        }

        // Génerer le token JWT
        String token = jwtService.generateToken(user.getEmail(), user.getRole().name());

        return new AuthResponse(token);
    }

    private boolean emailExists(String email) {
        return findUserByEmail(email) != null;
    }

    private User findUserByEmail(String email) {
        // Rechercher dans chaque repository
        Optional<Apprenant> apprenant = apprenatRepository.findByEmail(email);
        if (apprenant.isPresent()) {
            return apprenant.get();
        }

        Optional<Formateur> formateur = formateurRepository.findByEmail(email);
        if (formateur.isPresent()) {
            return formateur.get();
        }

        Optional<Administrateur> admin = administrateurRepository.findByEmail(email);
        if (admin.isPresent()) {
            return admin.get();
        }

        return null;
    }

    private User createUserByRole(RegisterRequest request) {
        switch (request.getRole()) {
            case APPRENANT:
                return new Apprenant();
            case FORMATEUR:
                return new Formateur();
            case ADMIN:
                return new Administrateur();
            default:
                throw new RuntimeException("Rôle non supporté");
        }
    }

    private void saveUserByRole(User user) {
        switch (user.getRole()) {
            case APPRENANT:
                apprenatRepository.save((Apprenant) user);
                break;
            case FORMATEUR:
                formateurRepository.save((Formateur) user);
                break;
            case ADMIN:
                administrateurRepository.save((Administrateur) user);
                break;
            default:
                throw new RuntimeException("Rôle non supporté");
        }
    }
}