package org.example.authservice.dtos;

public class AuthResponse {

    public String token;

    public AuthResponse(String token) {
        this.token = token;
    }
}
