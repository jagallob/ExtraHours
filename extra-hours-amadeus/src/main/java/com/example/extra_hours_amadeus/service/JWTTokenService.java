package com.example.extra_hours_amadeus.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JWTTokenService {

    private final Set<String> invalidTokens = new HashSet<>();

    public void invalidateToken(String token) {
        invalidTokens.add(token);
    }

    public boolean isTokenInvalid(String token) {
        return invalidTokens.contains(token);
    }
}
