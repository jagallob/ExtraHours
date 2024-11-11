package com.example.extra_hours_amadeus.controller;

import com.example.extra_hours_amadeus.service.JWTTokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logout")

public class LogoutController {

    @Autowired
    private JWTTokenService jwtTokenService;

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token, HttpServletRequest request, HttpServletResponse response) {
        try {
            // Extraer el token JWT de la cabecera Authorization
            String jwtToken = token.substring(7); // Quitar el prefijo "Bearer "

            // Invalidar el token JWT
            jwtTokenService.invalidateToken(jwtToken);

            // Limpiar el contexto de seguridad de Spring
            SecurityContextHolder.clearContext();

            // Invalidar la sesión HTTP
            request.getSession().invalidate();

            // Devolver una respuesta de éxito
            return ResponseEntity.ok("Logout successful");
        } catch (Exception e) {
            // Manejar cualquier excepción y devolver una respuesta adecuada
            return ResponseEntity.status(HttpServletResponse.SC_BAD_REQUEST).body("Logout failed");
        }
    }
}

