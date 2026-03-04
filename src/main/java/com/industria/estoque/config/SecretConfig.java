package com.industria.estoque.config;

import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class SecretConfig {

    public String getSecret(String secret) {
        try {
            return Files.readString(Paths.get("/run/secrets/" + secret)).trim();
        } catch (Exception e) {
            throw new RuntimeException("Secret não encontrada!: " + secret);
        }
    }

}
